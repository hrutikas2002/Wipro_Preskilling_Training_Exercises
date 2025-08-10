package com.wipro.webmvc.service.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CarRepo {
	public List<String> getCars() {
		List<String> carList= Arrays.asList("Toyota", "Honda", "Hyundai");
		return carList;
	}
}
