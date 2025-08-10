package com.wipro.orderms.dto;

public class PaymentDTO {
	private int orderId;
    private boolean paymentStatus;
    private String paymentMode;
    private double amount;
    private String paymentDescription;
	public PaymentDTO(int orderId, boolean paymentStatus, String paymentMode, double amount,
			String paymentDescription) {
		super();
		this.orderId = orderId;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.paymentDescription = paymentDescription;
	}
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
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
		return "PaymentDTO [orderId=" + orderId + ", paymentStatus=" + paymentStatus + ", paymentMode=" + paymentMode
				+ ", amount=" + amount + ", paymentDescription=" + paymentDescription + "]";
	}
    
    
}
