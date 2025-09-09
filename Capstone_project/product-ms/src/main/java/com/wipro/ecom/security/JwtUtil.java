package com.wipro.ecom.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;          // <-- important import for 0.11.5
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	private Key key() {
		// SECRET_KEY must be >= 32 bytes for HS256
		return Keys.hmacShaKeyFor(AppConstant.SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	}

	public String generateToken(String userId, int userType, int id) {
		String role = (userType == 0) ? "ROLE_ADMIN" : "ROLE_CUSTOMER";
		Map<String, Object> claims = new HashMap<>();
		claims.put("role", role);
		claims.put("uid", id);

		return Jwts.builder()
				.setClaims(claims) 
				.setSubject(userId)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + AppConstant.EXPIRATION_TIME))
				.signWith(key(), SignatureAlgorithm.HS256) // <-- SignatureAlgorithm enum, not Jwts.SignatureAlgorithm
				.compact();
	}

	private Claims claims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key()) 
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	public String extractUserId(String token) { return claims(token).getSubject(); }
	public String extractRole(String token)    { return claims(token).get("role", String.class); }
	public Integer extractUid(String token)    { return claims(token).get("uid", Integer.class); }
}
