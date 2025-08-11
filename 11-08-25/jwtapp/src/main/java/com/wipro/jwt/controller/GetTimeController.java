package com.wipro.jwt.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
@RestController
public class GetTimeController {
	 private final String SECRET_KEY = "mySecretKey";
	@RequestMapping("/getCurrentTime")
	public String getCurrentTime(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return "Missing or invalid Authorization header!";
        }

        String token = authHeader.substring(7);
        try {
            Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token);
            return "Current Date-Time: " + LocalDateTime.now();
        } catch (Exception e) {
            return "Invalid or expired token!";
        }
    }
}
