package com.wipro.springjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.springjpa.entity.Product;
import com.wipro.springjpa.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo productRepo;
	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product findById(int id) {
		return productRepo.findById(id).orElse(null);
	}
	
	

	@Override
	public void deleteById(int id) {
		productRepo.deleteById(id);
	}

	@Override
	public Product update(int id, Product updated) {
		Product p = productRepo.findById(id).orElse(null);
        if (p != null) {
            p.setProductName(updated.getProductName());
            p.setProductMake(updated.getProductMake());
            p.setProductPrice(updated.getProductPrice());
            return productRepo.save(p);
        }
        return null;
	}
	
	public List<Product> findByMake(String productMake) {
        return productRepo.findByProductMake(productMake);
    }
	
	public List<Product> searchByNameAndMakeSorted(String productName, String productMake) {
	    return productRepo.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
	    return productRepo.findAll(pageable);
	}

}
