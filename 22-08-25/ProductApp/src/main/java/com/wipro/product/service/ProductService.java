package com.wipro.product.service;

import java.util.List;

import com.wipro.product.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(Long id);
	Product addProduct(Product product);
	Product updateProduct(Long id, Product product);
	void deleteProduct(Long id);
}
