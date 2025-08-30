package com.wipro.product.service;

import java.util.List;

import com.wipro.product.entity.OrderHistory;

public interface OrderService {
	public String placeOrder(Long productId, int purchaseQty);
	public List<OrderHistory> getAllOrders();
}
