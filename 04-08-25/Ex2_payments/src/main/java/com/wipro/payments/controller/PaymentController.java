package com.wipro.payments.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.wipro.payments.entity.Payment;
import com.wipro.payments.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    // Save Payment - POST
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Payment payment) {
        paymentService.save(payment);
        HttpHeaders headers = new HttpHeaders();
        headers.add("created-at", LocalDate.now().toString()); // Only date, no time
        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .headers(headers)
                .body("Data Saved Successfully");
    }

    // Update Payment - PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Payment payment) {
        payment.setId(id); // ensure correct ID
        paymentService.save(payment);
        return ResponseEntity
                .status(HttpStatus.OK) // 200
                .body("Data Modified Successfully");
    }

    // Delete Payment - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        Optional<Payment> optionalPayment = paymentService.findById(id);
        if (optionalPayment.isPresent()) {
            paymentService.delete(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Data Deleted Successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Payment Not Found");
        }
    }

    // Find All - GET
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Payment> payments = paymentService.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("search-time", LocalDateTime.now().toString());

        if (payments.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .headers(headers)
                    .body("No Payments Found");
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(payments);
    }

    // Find By Id - GET
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Payment> optionalPayment = paymentService.findById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("search-time", LocalDateTime.now().toString());

        if (optionalPayment.isPresent()) {
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(optionalPayment.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .headers(headers)
                    .body("Payment Not Found");
        }
    }
}
