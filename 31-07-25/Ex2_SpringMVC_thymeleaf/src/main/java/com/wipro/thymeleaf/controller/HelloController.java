package com.wipro.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/welcome")
	public String showWelcomePage(Model model) {
		model.addAttribute("username", "Hrutika");
		model.addAttribute("message", "Welcome to Spring MVC with Thymeleaf!");
		return "index"; 
	}

}
