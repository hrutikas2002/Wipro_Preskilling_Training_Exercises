package com.wipro.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.order.dto.OrderResponse;
import com.wipro.order.entity.Order;
import com.wipro.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }
    
    @GetMapping("/{id}")
    public OrderResponse getOrderWithPayment(@PathVariable int id) {
        return orderService.getOrderWithPayment(id);
    }
}
