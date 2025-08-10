package com.wipro.rest.dto;

public class Mobile {
	private int id;
	private String make;
    private String modelNumber;
    private double price;
	
	public Mobile(int id, String make, String modelNumber, double price) {
		super();
		this.id = id;
		this.make = make;
		this.modelNumber = modelNumber;
		this.price = price;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", make=" + make + ", modelNumber=" + modelNumber + ", price=" + price + "]";
	}
	
}
