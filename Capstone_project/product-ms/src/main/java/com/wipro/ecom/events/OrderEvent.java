package com.wipro.ecom.events;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEvent {
    // "CREATED", "CANCELLED", "REJECTED"
    private String type;
    private Integer orderId;
    private Integer userId;
    private List<OrderItem> items;
    private Double totalAmount;
    private Instant eventTs;
}
