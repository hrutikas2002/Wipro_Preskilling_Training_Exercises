package com.wipro.solid;

public class GooglePay implements DigitalPayment {

	public void pay(double amount) {
		System.out.println(amount+"Paid via Google Pay");
	}

}
