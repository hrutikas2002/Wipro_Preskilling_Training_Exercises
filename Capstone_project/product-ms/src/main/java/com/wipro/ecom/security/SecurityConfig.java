package com.wipro.ecom.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean public JwtUtil jwtUtil() { return new JwtUtil(); }
    @Bean public JwtFilter jwtFilter(JwtUtil jwtUtil) { return new JwtFilter(jwtUtil); }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
                .requestMatchers("/error").permitAll() 
                .requestMatchers(HttpMethod.GET, "/product/**").permitAll() 
                .requestMatchers(HttpMethod.GET, "/product/img/**").permitAll()
                .anyRequest().authenticated() // writes require JWT; use @PreAuthorize for roles
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
