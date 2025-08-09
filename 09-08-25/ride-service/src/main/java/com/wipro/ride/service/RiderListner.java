package com.wipro.ride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.ride.constants.AppConstant;
import com.wipro.ride.entity.Ride;
import com.wipro.ride.repository.RideRepository;

@Service
public class RiderListner {
	@Autowired
	RideRepository rideRepository;
	
	@KafkaListener(topics=AppConstant.INCOMING_TOPIC_NAME,groupId="rider_grp")
	void processRiderMessage(Ride ride)
	{
		
		System.out.println("--Message Received by Ride="+ride);
		Ride ridedb=rideRepository.findById(ride.getId()).get();
		ridedb.setStatus(ride.isStatus());
		rideRepository.save(ridedb);
		
	}
}
