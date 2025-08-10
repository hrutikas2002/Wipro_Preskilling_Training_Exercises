package com.wipro.order.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.order.dto.PaymentDTO;

@FeignClient(name = "paymentms",fallback = PaymentFallbackService.class)
public interface PaymentConnectService {
	@PostMapping("/payment")
	ResponseEntity<PaymentDTO> savePaymentData(@RequestBody PaymentDTO  payment);
	
	@GetMapping("/payment/order/{orderId}")
    PaymentDTO getPaymentByOrderId(@PathVariable("orderId") int orderId);
}
