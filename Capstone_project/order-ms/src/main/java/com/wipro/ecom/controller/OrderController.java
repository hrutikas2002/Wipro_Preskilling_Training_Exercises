package com.wipro.ecom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ecom.entity.Order;
import com.wipro.ecom.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.var;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name="Order")
public class OrderController {
	private final OrderService orderService;

	@Operation(summary="Create order from cart")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Map<String,Object>> createOrder(Authentication auth) {
		int userId = Integer.parseInt(auth.getName());
		var res = orderService.createOrderSaga(userId);
		return ResponseEntity.accepted().body(res); // 202 Accepted { orderId, status:"PENDING" }
	}

	@Operation(summary="Cancel order")
	@PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
	@PutMapping("/{orderId}")
	public void cancelOrder(@PathVariable int orderId) {
		orderService.cancelOrder(orderId);
	}

	@Operation(summary="List all orders (admin)")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/{orderId}")
	public Order getOrderById(@PathVariable int orderId) {
		return orderService.getOrderDetails(orderId);
	}

	@Operation(summary="List orders for a user")
	@PreAuthorize("hasRole('ADMIN') or #userId.toString() == authentication.name")
	@GetMapping("/user/{userId}")
	public List<Order> getOrdersByUser(@PathVariable int userId) {
		return orderService.getOrdersByUser(userId);
	}

	@Operation(summary="Order details")
	@PreAuthorize("hasRole('ADMIN') or @orderSecurity.isOwner(authentication,#orderId)")
	@GetMapping("/details/{orderId}")
	public Order getOrderDetails(@PathVariable int orderId) {
		return orderService.getOrderDetails(orderId);
	}

	@Operation(summary="My order history")
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/history")
	public List<Order> myOrderHistory(Authentication auth) {
		int uid = Integer.parseInt(auth.getName());
		return orderService.getOrdersByUser(uid);
	}
}
