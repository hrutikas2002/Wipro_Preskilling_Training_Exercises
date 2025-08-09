package com.wipro.uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.uber.entity.Uber;

public interface UberRepository extends JpaRepository<Uber, Integer>{
	Uber findByRiderId(String riderId);
}
