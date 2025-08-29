package com.wipro.ecom.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(AppConstant.SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

	public String extractUserId(String token) {
		return Jwts.parserBuilder()
                .setSigningKey(AppConstant.SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
	}
}
