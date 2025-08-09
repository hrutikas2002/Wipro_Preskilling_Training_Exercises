package com.wipro.ride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ride.entity.Ride;
import com.wipro.ride.service.RideService;

@RestController
@RequestMapping("/ride")
public class RideController {
	@Autowired
	RideService rideService;
	
	@PostMapping
	void book(@RequestBody Ride ride)
	{
		rideService.bookRide(ride);
	}
	
}
