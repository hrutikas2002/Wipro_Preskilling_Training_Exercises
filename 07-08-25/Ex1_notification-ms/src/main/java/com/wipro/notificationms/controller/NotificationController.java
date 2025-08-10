package com.wipro.notificationms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.notificationms.dto.NotificationDTO;

@RestController
@RequestMapping("/notify")
public class NotificationController {

	@PostMapping
	public ResponseEntity<String> notify(@RequestBody NotificationDTO request) {
		String message = "User " + request.getUser().getUsername() + " information is " + request.getAction();

		System.out.println("Received Notification: " + message);

		return ResponseEntity.ok(message);
	}
}
