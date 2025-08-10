package com.wipro.order.service;



import com.wipro.order.dto.OrderResponse;
import com.wipro.order.entity.Order;

public interface OrderService {
    String placeOrder(Order order);
    OrderResponse getOrderWithPayment(int id);
}

