package com.wipro.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.product.entity.OrderHistory;

public interface OrderRepository extends JpaRepository<OrderHistory, Long>{

}
