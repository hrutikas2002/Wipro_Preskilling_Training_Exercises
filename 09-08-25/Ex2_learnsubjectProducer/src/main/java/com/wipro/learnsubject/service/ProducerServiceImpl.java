package com.wipro.learnsubject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.learnsubject.entity.Subject;
@Service
public class ProducerServiceImpl implements ProducerService{
	@Autowired
    private KafkaTemplate<String, Subject> kafkaTemplate;

    public void sendSubject(Subject subject) {
        kafkaTemplate.send("learn-subject", subject);
        System.out.println("Message sent to Kafka: " + subject);
    }
}
