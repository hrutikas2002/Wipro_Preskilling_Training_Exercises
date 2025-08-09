package com.wipro.learnsubject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.learnsubject.service.ProducerService;

@RestController
@RequestMapping("/learnsubject")
public class ProducerController {
	 @Autowired
	    private ProducerService producerService;

	    @GetMapping("/{message}")
	    public String sendMessage(@PathVariable String message) {
	    	producerService.sendMessage(message);
	        return "Message published: " + message;
}
}
