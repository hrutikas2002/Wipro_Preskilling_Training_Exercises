package com.wipro.ecom.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.wipro.ecom.service.OrderService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderSecurity {
  private final OrderService orderService;
  public boolean isOwner(Authentication auth, Integer orderId){
    String userId = (String) auth.getPrincipal();
    return orderService.isOrderOwnedByUser(orderId, userId);
  }
}
