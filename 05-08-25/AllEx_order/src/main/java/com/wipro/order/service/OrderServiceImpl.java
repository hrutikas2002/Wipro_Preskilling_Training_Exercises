package com.wipro.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.order.dto.OrderResponse;
import com.wipro.order.dto.PaymentDTO;
import com.wipro.order.entity.Order;
import com.wipro.order.repo.OrderRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private PaymentConnectService paymentConnectService;

//    @Override
//    public String placeOrder(Order order) {
//        // 1. Save with status I
//        order.setOrderStatus("I");
//        Order savedOrder = orderRepo.save(order);
//
//        // 2. Prepare DTO
//        PaymentDTO payment = new PaymentDTO();
//        payment.setOrderId(savedOrder.getId());
//        payment.setAmount(savedOrder.getOrderValue());
//        payment.setDescription("Payment for Order " + savedOrder.getOrderNumber());
//        payment.setPaymentMode("UPI");
//        payment.setPaymentStatus(true);
//
//        // 3. Call Payment Service via Feign
//        try {
//            paymentConnectService.savePaymentData(payment); 
//            savedOrder.setOrderStatus("P");
//        } catch (Exception e) {
//            savedOrder.setOrderStatus("C");
//        }
//
//        orderRepo.save(savedOrder);
//        return "Order placed with status: " + savedOrder.getOrderStatus();
//    }
//    @Override
//    public OrderResponse getOrderWithPayment(int id) {
//        OrderResponse response = new OrderResponse();
//        Order order = orderRepo.findById(id).orElse(null);
//
//        if (order != null) {
//            response.setOrder(order);
//            try {
//                PaymentDTO payment = paymentConnectService.getPaymentByOrderId(order.getId());
//                response.setPayment(payment);
//            } catch (Exception e) {
//                response.setPayment(null); // If payment not found or error
//            }
//        }
//        return response;
//    }
    
    @Override
    @CircuitBreaker(name = "orderService", fallbackMethod = "handleFallBack")
    public String placeOrder(Order order) {
        order.setOrderStatus("I");
        Order savedOrder = orderRepo.save(order);

        PaymentDTO payment = new PaymentDTO();
        payment.setOrderId(savedOrder.getId());
        payment.setAmount(savedOrder.getOrderValue());
        payment.setDescription("Payment for Order " + savedOrder.getOrderNumber());
        payment.setPaymentMode("UPI");
        payment.setPaymentStatus(true);

        ResponseEntity<PaymentDTO> response = paymentConnectService.savePaymentData(payment);
        if (response.getStatusCode().is2xxSuccessful()) {
            savedOrder.setOrderStatus("P");
        }

        orderRepo.save(savedOrder);
        return "Order placed with status: " + savedOrder.getOrderStatus();
    }

    public String handleFallBack(Order order, Throwable t) {
        order.setOrderStatus("C");
        orderRepo.save(order);
        return "System is down. Order placed with status: C";
    }

    @Override
    public OrderResponse getOrderWithPayment(int id) {
        OrderResponse response = new OrderResponse();
        Order order = orderRepo.findById(id).orElse(null);

        if (order != null) {
            response.setOrder(order);
            try {
                PaymentDTO payment = paymentConnectService.getPaymentByOrderId(order.getId());
                response.setPayment(payment);
            } catch (Exception e) {
                response.setPayment(null);
            }
        }
        return response;
    }
}
