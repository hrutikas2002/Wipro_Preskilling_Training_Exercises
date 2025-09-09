package com.wipro.ecom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import lombok.var;

@Configuration
public class FeignSecurityConfig {
  @Bean
  public RequestInterceptor authForwarder() {
    return template -> {
      var attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      if (attrs != null) {
        String auth = attrs.getRequest().getHeader("Authorization");
        if (auth != null && !auth.isBlank()) {
          template.header("Authorization", auth);
        }
      }
    };
  }
}