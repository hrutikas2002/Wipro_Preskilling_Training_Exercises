package com.wipro.employeemvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.employeemvc.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
