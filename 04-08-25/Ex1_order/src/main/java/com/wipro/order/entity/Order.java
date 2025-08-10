package com.wipro.order.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_data")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderNumber;
    private double orderValue;
    private String orderStatus; // I, P, C
}

