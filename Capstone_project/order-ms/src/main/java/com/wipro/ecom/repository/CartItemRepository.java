package com.wipro.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
