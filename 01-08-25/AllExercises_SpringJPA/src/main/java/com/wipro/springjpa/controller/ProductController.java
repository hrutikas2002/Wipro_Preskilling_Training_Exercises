package com.wipro.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springjpa.entity.Product;
import com.wipro.springjpa.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Product", description = "Products management APIs")

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService service;

	@Operation(summary = "Add a new product")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product added successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid product input")
    })
    @PostMapping
    public Product create(@RequestBody Product p) {
        return service.save(p);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @Operation(summary = "Get a product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public Product getOne(@PathVariable int id) {
        return service.findById(id);
    }

    @Operation(summary = "Update an existing product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product updated"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product p) {
        return service.update(id, p);
    }

    @Operation(summary = "Delete a product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "Deleted Successfully";
    }

    @Operation(summary = "Get products by product make")
    @GetMapping("/make/{productMake}")
    public List<Product> getByMake(@PathVariable String productMake) {
        return service.findByMake(productMake);
    }

    @Operation(summary = "Search by product name and make, sorted by name descending")
    @GetMapping("/search")
    public List<Product> searchByNameAndMakeSorted(
            @RequestParam String productName,
            @RequestParam String productMake) {
        return service.searchByNameAndMakeSorted(productName, productMake);
    }

    @Operation(summary = "Get paginated products sorted by price")
    @GetMapping("/page/{pageNum}/{pageSize}/{sortOrder}")
    public Page<Product> findAllPage(
            @PathVariable int pageNum,
            @PathVariable int pageSize,
            @PathVariable int sortOrder) {

        Pageable p;
        if (sortOrder == 0) {
            p = PageRequest.of(pageNum, pageSize, Sort.by("productPrice").descending());
        } else {
            p = PageRequest.of(pageNum, pageSize, Sort.by("productPrice").ascending());
        }

        return service.findAll(p);
    }
}
