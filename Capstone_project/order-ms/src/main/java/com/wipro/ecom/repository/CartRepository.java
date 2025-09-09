package com.wipro.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ecom.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	 @EntityGraph(attributePaths = "items")
    Optional<Cart> findByUserId(int userId);
}
