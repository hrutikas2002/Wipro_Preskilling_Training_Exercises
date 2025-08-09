package com.wipro.uber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.uber.dto.Ride;
import com.wipro.uber.entity.Uber;
import com.wipro.uber.repository.UberRepository;
import com.wipro.uber.util.AppConstant;
@Service
public class UberServiceImpl implements UberService{

	@Autowired
	UberRepository uberRepository;
	
	@Autowired
	KafkaTemplate kafkaTemplate;

	@KafkaListener(topics = AppConstant.INCOMING_TOPIC_NAME, groupId = "uber_rider_grp")
	public void receiveBooking(Ride ride) {
		System.out.println("---Message Received by Uber Service--- " + ride);
		ride.setStatus(true);
	}

	@Override
	public void save(Uber uber) {
		uberRepository.save(uber);
	}
}
