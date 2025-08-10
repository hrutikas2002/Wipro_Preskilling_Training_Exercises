package com.wipro.springjpa.entity;

import jakarta.persistence.*;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(name="product_name")
    private String productName;
	@Column(name="product_make")
    private String productMake;
	@Column(name="product_price")
    private double productPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductMake() {
		return productMake;
	}
	public void setProductMake(String productMake) {
		this.productMake = productMake;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productMake=" + productMake + ", productPrice="
				+ productPrice + "]";
	}
}
