package com.wipro.learnsubject.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wipro.learnsubject.entity.Subject;

@Component
public class LearnConsumer {
	@KafkaListener(topics = "learn-subject", groupId = "group_id")
    public void consume(Subject subject) {
        System.out.println("Consumed message: " + subject);
    }
}
