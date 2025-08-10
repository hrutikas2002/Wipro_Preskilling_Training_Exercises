package com.wipro.carms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.carms.entity.CarRegistrationDetail;

public interface CarRegistrationRepository extends JpaRepository<CarRegistrationDetail, Long> {

}
