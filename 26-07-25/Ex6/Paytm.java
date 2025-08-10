package com.wipro.solid;

public class Paytm implements DigitalPayment {

	@Override
	public void pay(double amount) {
		System.out.println(amount+"Paid via paytm");
	}

}
