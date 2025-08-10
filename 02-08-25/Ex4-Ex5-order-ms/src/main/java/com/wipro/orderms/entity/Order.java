package com.wipro.orderms.entity;

import jakarta.persistence.*;

@Entity(name="Order_Details")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="Order_number")
	String orderNumber;
	@Column(name="Order_value")
	double orderValue;
	@Column(name = "Order_status")
	String orderStatus;
	public Order(String orderNumber, double orderValue, String orderStatus) {
		super();
		this.orderNumber = orderNumber;
		this.orderValue = orderValue;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderValue=" + orderValue + ", orderStatus="
				+ orderStatus + "]";
	}
}
