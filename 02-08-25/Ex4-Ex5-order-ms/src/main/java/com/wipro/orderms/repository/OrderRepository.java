package com.wipro.orderms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.orderms.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
