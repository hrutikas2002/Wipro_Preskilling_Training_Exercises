package com.wipro.order.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.wipro.order.dto.PaymentDTO;

@Component
public class PaymentFallbackService implements PaymentConnectService {

@Override
public ResponseEntity<PaymentDTO> savePaymentData(PaymentDTO payment) {
    PaymentDTO fallbackPayment = new PaymentDTO();
    fallbackPayment.setOrderId(payment.getOrderId());
    fallbackPayment.setAmount(0);
    fallbackPayment.setDescription("Fallback: Payment service unavailable");
    fallbackPayment.setPaymentMode("N/A");
    fallbackPayment.setPaymentStatus(false);

    return ResponseEntity.ok(fallbackPayment);
}

@Override
public PaymentDTO getPaymentByOrderId(int orderId) {
    PaymentDTO fallbackPayment = new PaymentDTO();
    fallbackPayment.setOrderId(orderId);
    fallbackPayment.setAmount(0);
    fallbackPayment.setDescription("Fallback: Payment service unavailable");
    fallbackPayment.setPaymentMode("N/A");
    fallbackPayment.setPaymentStatus(false);
    return fallbackPayment;
}
}
