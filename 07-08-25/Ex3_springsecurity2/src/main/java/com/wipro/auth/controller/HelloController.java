package com.wipro.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/greet")
    public String greet() {
        return "Hello from Greet";
    }
	
	@GetMapping("/hello")
    public String hello() {
        return "Hello!! Authentication not required for this API";
    }

    @GetMapping("/secure")
    public String secure() {
        return "Secure - authentication required!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin - also needs authentication!";
    }
}
