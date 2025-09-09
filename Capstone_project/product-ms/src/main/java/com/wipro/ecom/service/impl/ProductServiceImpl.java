package com.wipro.ecom.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.ecom.entity.Product;
import com.wipro.ecom.repository.ProductRepository;
import com.wipro.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        Product existing = productRepository.findById(product.getId())
            .orElseThrow(() -> new RuntimeException("Product not found with id " + product.getId()));

        existing.setProdName(product.getProdName());
        existing.setProdDesc(product.getProdDesc());
        existing.setProdCat(product.getProdCat());
        existing.setMake(product.getMake());
        existing.setAvailableQty(product.getAvailableQty());
        existing.setPrice(product.getPrice());
        existing.setUom(product.getUom());
        existing.setProdRating(product.getProdRating());
        existing.setImageURL(product.getImageURL());
        existing.setDateOfManufacture(product.getDateOfManufacture());

        return productRepository.save(existing);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkAvailability(Map<Integer, Integer> productQty) {
        for (Map.Entry<Integer, Integer> entry : productQty.entrySet()) {
            int productId = entry.getKey();
            int requestedQty = Math.max(0, entry.getValue());
            Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));
            if (product.getAvailableQty() < requestedQty) return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void reduceStock(Map<Integer, Integer> productQty) {
        for (Map.Entry<Integer, Integer> entry : productQty.entrySet()) {
            int productId = entry.getKey();
            int qty = Math.max(0, entry.getValue());
            Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));

            int newQty = product.getAvailableQty() - qty;
            if (newQty < 0) throw new RuntimeException("Insufficient stock for product id " + productId);
            product.setAvailableQty(newQty);
            productRepository.save(product);
        }
    }

    @Override
    @Transactional
    public void increaseStock(Map<Integer, Integer> productQty) {
        for (Map.Entry<Integer, Integer> entry : productQty.entrySet()) {
            increaseStock(entry.getKey(), entry.getValue());
        }
    }

    @Override
    @Transactional
    public void increaseStock(Integer productId, Integer by) {
        int inc = Math.max(0, by == null ? 0 : by);
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));
        product.setAvailableQty(product.getAvailableQty() + inc);
        productRepository.save(product);
    }
}
