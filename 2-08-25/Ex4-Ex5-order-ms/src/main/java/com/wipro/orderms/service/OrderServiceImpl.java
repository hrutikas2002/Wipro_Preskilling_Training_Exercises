package com.wipro.orderms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.orderms.dto.PaymentDTO;
import com.wipro.orderms.entity.Order;
import com.wipro.orderms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order placeOrder(Order order) {
        // Step 1: Initiate order
        order.setOrderStatus("I");
        Order savedOrder = orderRepository.save(order);

        // Step 2: Create payment DTO
        PaymentDTO payment = new PaymentDTO();
        payment.setOrderId(savedOrder.getId());
        payment.setPaymentStatus(true);
        payment.setPaymentMode("UPI");
        payment.setAmount(savedOrder.getOrderValue());
        payment.setPaymentDescription("Payment for Order");

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:9011/payment/doPayment", payment, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                savedOrder.setOrderStatus("P");
            } else {
                savedOrder.setOrderStatus("C");
            }
        } catch (Exception e) {
            savedOrder.setOrderStatus("C");
        }

        return orderRepository.save(savedOrder);
    }
}