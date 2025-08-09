package com.wipro.uber.service;

import com.wipro.uber.dto.Ride;
import com.wipro.uber.entity.Uber;

public interface UberService {
	void receiveBooking(Ride ride);
	void save(Uber uber);
}
