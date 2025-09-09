package com.wipro.ecom.kafka;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wipro.ecom.entity.Product;
import com.wipro.ecom.events.OrderItem;
import com.wipro.ecom.events.OrderRequestedEvent;
import com.wipro.ecom.events.StockRejectedEvent;
import com.wipro.ecom.events.StockReservedEvent;
import com.wipro.ecom.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductSagaListener {

    private final ProductRepository productRepo;
    private final org.springframework.kafka.core.KafkaTemplate<String,Object> kafkaTemplate;

    @KafkaListener(topics = "order.requested", groupId = "product-ms", properties = { "spring.json.value.default.type=com.wipro.ecom.events.OrderRequestedEvent" })
    @Transactional
    public void onOrderRequested(OrderRequestedEvent evt) {
        log.info("[product-ms] order.requested orderId={} items={}", evt.getOrderId(), evt.getItems().size());

        // 1) Validate availability first
        Map<Integer,Integer> missing = new HashMap<>();
        for (OrderItem it : evt.getItems()) {
            Product p = productRepo.findById(it.getProductId()).orElse(null);
            int have = (p==null ? 0 : p.getAvailableQty());
            if (p == null || have < it.getQty()) {
                missing.put(it.getProductId(), have); // not enough
            }
        }

        if (!missing.isEmpty()) {
            // Publish rejection (no inventory changes)
            var rej = StockRejectedEvent.builder()
                .orderId(evt.getOrderId())
                .requestedItems(evt.getItems())
                .missing(missing)
                .reason("INSUFFICIENT_STOCK")
                .eventTs(Instant.now())
                .build();
            kafkaTemplate.send("stock.rejected", String.valueOf(evt.getOrderId()), rej);
            return;
        }

        // 2) Reserve: reduce stock
        for (OrderItem it : evt.getItems()) {
            Product p = productRepo.findById(it.getProductId()).orElseThrow();
            p.setAvailableQty(p.getAvailableQty() - it.getQty());
            productRepo.save(p);
        }

        // 3) Publish reserved
        var res = StockReservedEvent.builder()
            .orderId(evt.getOrderId())
            .items(evt.getItems())
            .eventTs(Instant.now())
            .build();
        kafkaTemplate.send("stock.reserved", String.valueOf(evt.getOrderId()), res);
        log.info("[product-ms] stock.reserved id={} items={}", evt.getOrderId(), evt.getItems().size());

    }
}