package com.wipro.springjpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.springjpa.entity.Product;

public interface ProductService {
	Product save(Product product);
	List<Product> findAll();
	Product findById(int id);
	Product update(int id, Product updated);
	void deleteById(int id);
	public List<Product> findByMake(String productMake) ;
	List<Product> searchByNameAndMakeSorted(String productName, String productMake);
	Page<Product> findAll(Pageable pageable);
}
