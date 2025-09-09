package com.wipro.ecom.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.wipro.ecom.entity.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> getAllProducts();
    Optional<Product> getProductById(int id);
    boolean checkAvailability(Map<Integer, Integer> productQty);
    void reduceStock(Map<Integer, Integer> productQty);
    void increaseStock(Map<Integer, Integer> productQty);

    // single-item increase (used by Kafka consumer on order.cancelled)
    void increaseStock(Integer productId, Integer by);
}
