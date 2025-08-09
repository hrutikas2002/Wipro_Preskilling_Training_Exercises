package com.wipro.learnsubject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.learnsubject.entity.Subject;
import com.wipro.learnsubject.service.ProducerService;

@RestController
@RequestMapping("/learnsubject")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/send")
    public String sendSubject(@RequestBody Subject subject) {
        producerService.sendSubject(subject);
        return "Subject sent: " + subject;
    }

}
