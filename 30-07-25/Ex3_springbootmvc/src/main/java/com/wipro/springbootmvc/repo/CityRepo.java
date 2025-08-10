package com.wipro.springbootmvc.repo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CityRepo {
	public List<String> getCities() {
        return Arrays.asList("Mumbai", "Nashik", "Dhule", "Chennai", "Banglore", "Pune");
    }
}
