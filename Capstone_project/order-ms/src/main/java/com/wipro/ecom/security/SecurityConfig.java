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
               // Swagger / docs
               .requestMatchers("/v3/api-docs/**","/swagger-ui/**").permitAll()

               // CART endpoints (customer or admin)
               .requestMatchers(HttpMethod.POST,   "/cart/addProd").hasAnyRole("CUSTOMER","ADMIN")
               .requestMatchers(HttpMethod.PUT,    "/cart/update").hasAnyRole("CUSTOMER","ADMIN")
               .requestMatchers(HttpMethod.DELETE, "/cart/deleteProd/**").hasAnyRole("CUSTOMER","ADMIN")
               .requestMatchers(HttpMethod.GET,    "/cart/**").hasAnyRole("CUSTOMER","ADMIN")

               // ORDER endpoints
               .requestMatchers(HttpMethod.POST, "/order").hasAnyRole("CUSTOMER","ADMIN") // place order
               .requestMatchers(HttpMethod.PUT,  "/order/**").hasAnyRole("CUSTOMER","ADMIN") // cancel, etc.

               // list all orders (admin only)
               .requestMatchers(HttpMethod.GET, "/order").hasRole("ADMIN")

               // get one order: authenticated (your @PreAuthorize will enforce owner/admin)
               .requestMatchers(HttpMethod.GET, "/order/**").authenticated()

               .anyRequest().authenticated()
           )
           .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
