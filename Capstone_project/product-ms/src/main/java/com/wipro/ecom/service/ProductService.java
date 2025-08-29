package com.wipro.ecom.service;

import java.util.List;
import java.util.Optional;

import com.wipro.ecom.entity.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> getAllProducts();
    Optional<Product> getProductById(int id);
}
