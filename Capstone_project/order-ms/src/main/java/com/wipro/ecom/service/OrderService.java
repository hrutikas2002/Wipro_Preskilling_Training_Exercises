package com.wipro.ecom.service;

import java.util.List;
import java.util.Map;

import com.wipro.ecom.dto.OrderResponseDTO;
import com.wipro.ecom.entity.Order;

public interface OrderService {

	//OrderResponseDTO createOrder(int userId);
	Map<String,Object> createOrderSaga(int userId);
	void cancelOrder(int orderId);
	public List<Order> getAllOrders();
	public List<Order> getOrdersByUser(int userId);
	public Order getOrderDetails(int orderId);
	boolean isOrderOwnedByUser(Integer orderId, String userId);
}