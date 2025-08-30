package com.wipro.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.product.entity.OrderHistory;
import com.wipro.product.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
    private OrderService orderService;

    @PostMapping("/place/{productId}")
    public ResponseEntity<Map<String, Object>> placeOrder(@PathVariable Long productId, 
                                             @RequestParam int qty) {
    	String message = orderService.placeOrder(productId, qty);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public List<OrderHistory> getOrderHistory() {
        return orderService.getAllOrders();
    }
}
