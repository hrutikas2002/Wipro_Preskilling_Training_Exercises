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
public class StockReservedEvent {
	private Integer orderId;
    private List<OrderItem> items; // what was reserved (same as requested)
    private Instant eventTs;
}
