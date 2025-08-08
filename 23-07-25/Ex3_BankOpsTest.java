package com.wipro.oops;

import com.wipro.oop.test.Citi;
import com.wipro.oop.test.HDFC;

public class BankOpsTest 
{
	public static void main(String[] args) {
		HDFC h = new HDFC();
		h.deposit(10000, "123456");
		double withdrawAmount1 = h.withdraw(5000, "12345");
		System.out.println("Amount taken from HDFC bank account: "+withdrawAmount1);
		
		Citi c = new Citi();
		h.deposit(50050, "890765");
		double withdrawAmount2 = h.withdraw(10000, "890765");
		System.out.println("Amount taken from Citi bank account: "+withdrawAmount2);
	}
}
