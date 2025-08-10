package com.wipro.payments.service.imp;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.payments.entity.Payment;
import com.wipro.payments.repo.PaymentRepo;
import com.wipro.payments.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public void save(Payment payment) {
        paymentRepo.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Optional<Payment> findById(int id) {
        return paymentRepo.findById(id);
    }

    @Override
    public void delete(int id) {
        paymentRepo.deleteById(id);
    }
}
