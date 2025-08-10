package com.wipro.paymentms.entity;

import jakarta.persistence.*;

@Entity(name="Payment_Details")
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column
    private int orderId;
	@Column
    private boolean paymentStatus;
	@Column
    private String paymentMode;
	@Column
    private double amount;
	@Column
    private String paymentDescription;
	public Payment(int orderId, boolean paymentStatus, String paymentMode, double amount, String paymentDescription) {
		super();
		this.orderId = orderId;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.paymentDescription = paymentDescription;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentDescription() {
		return paymentDescription;
	}
	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderId=" + orderId + ", paymentStatus=" + paymentStatus + ", paymentMode="
				+ paymentMode + ", amount=" + amount + ", paymentDescription=" + paymentDescription + "]";
	}
}
