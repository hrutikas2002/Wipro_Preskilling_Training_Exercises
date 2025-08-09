package com.wipro.learnsubject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class ProducerServiceImpl implements ProducerService{
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("learn-subject", message);
        System.out.println("Message sent to Kafka: " + message);
    }
}
