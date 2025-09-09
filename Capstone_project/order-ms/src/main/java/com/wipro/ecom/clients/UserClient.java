package com.wipro.ecom.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.ecom.dto.UserDTO;

@FeignClient(name = "user-ms")
public interface UserClient {
	@GetMapping("/user/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable("id") int id);
}
