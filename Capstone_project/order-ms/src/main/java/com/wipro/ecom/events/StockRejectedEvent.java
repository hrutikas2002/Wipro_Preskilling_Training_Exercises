package com.wipro.ecom.events;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class StockRejectedEvent {
    private Integer orderId;
    private Map<Integer, Integer> missing; // productId -> shortfall or available qty
    private List<OrderItem> requestedItems;
    private String reason;
    private Instant eventTs;
}
