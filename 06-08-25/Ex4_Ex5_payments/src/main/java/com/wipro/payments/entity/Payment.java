package com.wipro.payments.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payment_data")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_mode")
    private String paymentMode;

    private double amount;

    private String description;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "payment_status")
    private boolean paymentStatus;
}
