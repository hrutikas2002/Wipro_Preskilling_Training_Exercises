package com.wipro.ride.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.ride.constants.AppConstant;
import com.wipro.ride.entity.Ride;
import com.wipro.ride.repository.RideRepository;

@Service
public class RideServiceImpl implements RideService{
	
	@Autowired
	RideRepository rideRepository;
	
	@Autowired
	KafkaTemplate kafkaTemplate;
	
	@Override
	public void bookRide(Ride ride) {
		ride.setStatus(false);
		ride.setBookingDate(LocalDate.now());
		rideRepository.save(ride); // Save in Rider DB
	    
	    // Send the booking details to Uber via Kafka
	    kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, ride);
	}
}
