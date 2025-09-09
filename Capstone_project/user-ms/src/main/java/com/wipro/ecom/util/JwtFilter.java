package com.wipro.ecom.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.var;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;


@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
    private JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
            	String userId = jwtUtil.extractUserId(token);
            	String role = jwtUtil.extractRole(token);
            	if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            	    var authorities = List.of(new SimpleGrantedAuthority(role));
            	    UsernamePasswordAuthenticationToken authentication =
            	        new UsernamePasswordAuthenticationToken(userId, null, authorities);
            	    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            	    SecurityContextHolder.getContext().setAuthentication(authentication);
            	}
            } catch (Exception e) {
                System.out.println("Invalid JWT Token: " + e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }
}