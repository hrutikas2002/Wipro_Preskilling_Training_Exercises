package com.wipro.ecom.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.wipro.ecom.clients.ProductClient;
import com.wipro.ecom.entity.Cart;
import com.wipro.ecom.entity.CartItem;
import com.wipro.ecom.entity.Order;
import com.wipro.ecom.events.OrderEvent;
import com.wipro.ecom.events.OrderItem;
import com.wipro.ecom.events.OrderRequestedEvent;
import com.wipro.ecom.repository.CartRepository;
import com.wipro.ecom.repository.OrderRepository;
import com.wipro.ecom.service.OrderService;

import lombok.var;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired private OrderRepository orderRepo;
    @Autowired private CartRepository cartRepo;
    @Autowired private ProductClient productClient;
    @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    @Transactional
    public Map<String,Object> createOrderSaga(int userId) {
        Cart cart = cartRepo.findByUserId(userId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        if (cart.getItems()==null || cart.getItems().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cart is empty");
        }

        // Snapshot items
        var qtyByProduct = cart.getItems().stream().collect(
            Collectors.toMap(CartItem::getProductId, CartItem::getQty, Integer::sum)
        );

        // Persist order as PENDING
        Order order = new Order();
        order.setUserId(userId);
        order.setProductQuantityMap(new HashMap<>(qtyByProduct));
        order.setOrderStatus("PENDING");
        order.setOrderDate(LocalDateTime.now());
        orderRepo.save(order);

        // Publish order.requested
        var items = qtyByProduct.entrySet().stream()
            .map(e -> new OrderItem(e.getKey(), e.getValue()))
            .collect(Collectors.toList());

        var evt = OrderRequestedEvent.builder()
            .orderId(order.getOrderId())
            .userId(userId)
            .items(items)
            .eventTs(Instant.now())
            .build();

        kafkaTemplate.send("order.requested",
            String.valueOf(order.getOrderId()), evt);

        return Map.of("orderId", order.getOrderId(), "status", "PENDING");
    }

    @Override
    @Transactional
    public void cancelOrder(int orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));

        if (!"CANCELLED".equals(order.getOrderStatus())) {
            order.setOrderStatus("CANCELLED");
            orderRepo.save(order);

            // Build items from stored productQuantityMap
            var itemsList = order.getProductQuantityMap().entrySet().stream()
                    .map(e -> new OrderItem(e.getKey(), e.getValue()))
                    .collect(Collectors.toList());

            var cancelledEvt = OrderEvent.builder()
                    .type("CANCELLED")
                    .orderId(order.getOrderId())
                    .userId(order.getUserId())
                    .items(itemsList)
                    .totalAmount(order.getTotalAmount())
                    .eventTs(Instant.now())
                    .build();

            // 🔔 publish the cancel event (no direct REST increaseStock here)
            kafkaTemplate.send("order.cancelled", String.valueOf(order.getOrderId()), cancelledEvt);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getOrdersByUser(int userId) {
        return orderRepo.findByUserId(userId);
    }

    @Override
    public Order getOrderDetails(int orderId) {
        return orderRepo.findById(orderId).orElseThrow();
    }

    @Override
    public boolean isOrderOwnedByUser(Integer orderId, String userId) {
        var opt = orderRepo.findById(orderId);
        if (opt.isEmpty()) return false;
        var order = opt.get();
        try {
            Integer uid = Integer.valueOf(userId); // assuming JwtFilter sets principal to UID string
            return Objects.equals(order.getUserId(), uid);
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
