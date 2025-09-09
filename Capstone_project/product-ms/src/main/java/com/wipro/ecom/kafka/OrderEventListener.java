package com.wipro.ecom.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ecom.events.OrderEvent;
import com.wipro.ecom.events.OrderItem;
import com.wipro.ecom.service.ProductService; // or use your repository directly

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventListener {

	private final ProductService productService; // implement an increaseStock(int productId, int by) method

	@KafkaListener(topics = "order.cancelled", groupId = "product-ms")
	@Transactional
	public void onOrderCancelled(OrderEvent evt) {
		if (evt == null || evt.getItems() == null) return;
		log.info("[product-ms] Consumed order.cancelled for orderId={}, items={}", evt.getOrderId(), evt.getItems().size());

		// restore inventory for each line
		for (OrderItem item : evt.getItems()) {
			try {
				productService.increaseStock(item.getProductId(), item.getQty());
			} catch (Exception ex) {
				log.error("Failed to increase stock for productId={} qty={} (orderId={})",
						item.getProductId(), item.getQty(), evt.getOrderId(), ex);
				// optional: DLQ / retry policy here
			}
		}
	}

	// (Optional) observe created events (analytics, cache, etc.)
	//    @KafkaListener(topics = "order.created", groupId = "product-ms")
	//    public void onOrderCreated(OrderRequestedEvent evt) {
	//        log.info("[product-ms] Seen order.created orderId={} total={}", evt.getOrderId(), evt.getTotalAmount());
	// usually no inventory action here since you already reduced stock synchronously

}