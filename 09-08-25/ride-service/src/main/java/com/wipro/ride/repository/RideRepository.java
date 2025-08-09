package com.wipro.ride.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.ride.entity.Ride;

public interface RideRepository extends JpaRepository<Ride, Long>{

}
