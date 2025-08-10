package com.wipro.payments.service;

import java.util.List;
import java.util.Optional;
import com.wipro.payments.entity.Payment;

public interface PaymentService {
    void save(Payment payment);
    List<Payment> findAll();
    Optional<Payment> findById(int id);
    void delete(int id);
}


