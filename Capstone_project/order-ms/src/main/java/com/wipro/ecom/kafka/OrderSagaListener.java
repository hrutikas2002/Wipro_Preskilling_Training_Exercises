package com.wipro.ecom.kafka;

import com.wipro.ecom.clients.ProductClient;
import com.wipro.ecom.entity.Order;
import com.wipro.ecom.events.*;
import com.wipro.ecom.repository.CartRepository;
import com.wipro.ecom.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderSagaListener {

	private final OrderRepository orderRepo;
	private final CartRepository cartRepo;
	private final ProductClient productClient;           // to compute price
	private final org.springframework.kafka.core.KafkaTemplate<String,Object> kafkaTemplate;

	@KafkaListener(topics = "stock.reserved", groupId = "order-ms",properties = { "spring.json.value.default.type=com.wipro.ecom.events.StockReservedEvent" })
	@Transactional
	public void onStockReserved(StockReservedEvent evt) {
		log.info("[order-ms] stock.reserved for orderId={}", evt.getOrderId());
		Order order = orderRepo.findById(evt.getOrderId()).orElse(null);
		if (order == null) return; // idempotent

		// Compute total using product price API
		double total = 0.0;
		for (OrderItem it : evt.getItems()) {
			Double price = productClient.getProductPrice(it.getProductId());
			if (price == null) price = 0.0;
			total += price * it.getQty();
		}

		order.setTotalAmount(total);
		order.setOrderStatus("CREATED");
		orderRepo.save(order);

		// Clear cart lines for that user
		cartRepo.findByUserId(order.getUserId()).ifPresent(c -> {
			c.getItems().clear();
			cartRepo.save(c);
		});

		// Publish order.created (for notifications/analytics)
		var created = OrderEvent.builder()
				.type("CREATED")
				.orderId(order.getOrderId())
				.userId(order.getUserId())
				.items(evt.getItems())
				.totalAmount(total)
				.eventTs(Instant.now())
				.build();
		kafkaTemplate.send("order.created", String.valueOf(order.getOrderId()), created);
	}

	@KafkaListener(topics = "stock.rejected", groupId = "order-ms",properties = { "spring.json.value.default.type=com.wipro.ecom.events.StockRejectedEvent" })
	@Transactional
	public void onStockRejected(StockRejectedEvent evt) {
		log.info("[order-ms] stock.rejected for orderId={} reason={}", evt.getOrderId(), evt.getReason());
		Order order = orderRepo.findById(evt.getOrderId()).orElse(null);
		if (order == null) return; // idempotent

		order.setOrderStatus("REJECTED");
		orderRepo.save(order);

		// Publish order.rejected
		var rej = OrderEvent.builder()
				.type("REJECTED")
				.orderId(order.getOrderId())
				.userId(order.getUserId())
				.items(evt.getRequestedItems())
				.totalAmount(0.0)
				.eventTs(Instant.now())
				.build();
		kafkaTemplate.send("order.rejected", String.valueOf(order.getOrderId()), rej);
	}
}
