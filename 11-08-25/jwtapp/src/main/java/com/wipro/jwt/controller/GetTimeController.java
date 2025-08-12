package com.wipro.jwt.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GetTimeController {
	@GetMapping("/getCurrentTime")
    public String getCurrentTime() {
        return "Current DateTime is: " + LocalDateTime.now().toString();
    }
}
