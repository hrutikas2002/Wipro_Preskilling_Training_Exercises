package com.wipro.oop.test;

public class Citi implements BankOps
{

	@Override
	public void deposit(double amount, String accNo) {
		System.out.println(amount+" deposited in Citi bank account having account number "+accNo);
	}

	@Override
	public double withdraw(double amount, String accNo) {
		return amount;
	}

}
