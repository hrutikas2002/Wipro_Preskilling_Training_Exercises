package com.wipro.ecom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ecom.entity.Product;
import com.wipro.ecom.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/product")
@Tag(name="Product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// Create Product
	@PostMapping()
	@Operation(summary="Create product")
	  @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product savedProduct = productService.createProduct(product);
		return ResponseEntity.ok(savedProduct);
	}

	// Update Product
	 @Operation(summary="Update product")
	  @PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
		product.setId(id);
		Product updatedProduct = productService.updateProduct(product);
		return ResponseEntity.ok(updatedProduct);
	}

	// Delete Product
	 @Operation(summary="Delete product")
	  @PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	    return ResponseEntity.noContent().build(); 
	}

	// Get All Products
	 @Operation(summary="List products")
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	// Get Product by ID
	 @Operation(summary="Get product detail")
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		return productService.getProductById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/checkAvailability")
	public ResponseEntity<Boolean> checkAvailability(@RequestBody Map<Integer, Integer> productQty) {
	    boolean available = productService.checkAvailability(productQty);
	    return ResponseEntity.ok(available);
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PutMapping("/reduceStock")
	public ResponseEntity<Void> reduceStock(@RequestBody Map<Integer, Integer> productQty) {
	    productService.reduceStock(productQty);
	    return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@PutMapping("/increaseStock")
	public ResponseEntity<Void> increaseStock(@RequestBody Map<Integer, Integer> productQty) {
	    productService.increaseStock(productQty);
	    return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/price")
    public ResponseEntity<Double> getProductPrice(@PathVariable int id) {
        return productService.getProductById(id)
                .map(product -> ResponseEntity.ok(product.getPrice()))
                .orElse(ResponseEntity.notFound().build());
    }
	
	
}
