package com.wipro.solid;

public class PhonePay implements DigitalPayment {

	public void pay(double amount) {
		System.out.println(amount+"paid via Phonepay");
	}

}
