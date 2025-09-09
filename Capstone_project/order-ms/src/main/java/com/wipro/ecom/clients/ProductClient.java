package com.wipro.ecom.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.ecom.dto.ProductDTO1;

@FeignClient(name = "product-ms")
public interface ProductClient {

	@GetMapping("/product/{id}/price")
	Double getProductPrice(@PathVariable("id") int productId);

	//    @PostMapping("/product/checkAvailability")
	//    Boolean checkAvailability(@RequestBody Map<Integer,Integer> productQty);
	//
	//    @PutMapping("/product/reduceStock")
	//    void reduceStock(@RequestBody Map<Integer,Integer> productQty);
	//
	//    @PutMapping("/product/increaseStock")
	//    void increaseStock(@RequestBody Map<Integer,Integer> productQty);

	@GetMapping("/product/{id}")
	ProductDTO1 getProduct(@PathVariable("id") int productId);
}

