package com.wipro.order.dto;

import com.wipro.order.entity.Order;

import lombok.Data;

@Data
public class OrderResponse {
    private Order order;
    private PaymentDTO payment;
}