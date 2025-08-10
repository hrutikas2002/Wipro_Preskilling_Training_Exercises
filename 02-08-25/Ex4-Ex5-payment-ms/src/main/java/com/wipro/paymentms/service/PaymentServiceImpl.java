package com.wipro.paymentms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.paymentms.entity.Payment;
import com.wipro.paymentms.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment doPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
