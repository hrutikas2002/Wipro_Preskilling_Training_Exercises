package com.wipro.order.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private String paymentMode;
    private double amount;
    private String description;
    private int orderId;
    private boolean paymentStatus;
}

