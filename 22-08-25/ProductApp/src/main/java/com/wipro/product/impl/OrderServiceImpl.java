package com.wipro.product.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.product.entity.OrderHistory;
import com.wipro.product.entity.Product;
import com.wipro.product.repository.OrderRepository;
import com.wipro.product.repository.ProductRepository;
import com.wipro.product.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private OrderRepository orderRepo;

	public String placeOrder(Long productId, int purchaseQty) {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));

		if (purchaseQty > product.getQty()) {
			throw new RuntimeException("Not enough stock available");
		}

		// reduce qty
		product.setQty(product.getQty() - purchaseQty);
		productRepo.save(product);

		// save order history
		OrderHistory order = new OrderHistory();
		order.setProductName(product.getName());
		order.setPurchasedQty(purchaseQty);
		order.setOrderDate(LocalDateTime.now());
		orderRepo.save(order);

		return "Order placed successfully";
	}

	public List<OrderHistory> getAllOrders() {
		return orderRepo.findAll();
	}
}
