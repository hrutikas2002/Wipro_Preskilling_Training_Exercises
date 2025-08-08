package com.wipro.exception;

public class TryCatchDemo 
{
	public static void main(String[] args) {
		String fname = null;
		String lowerName=null;
		
		try {
			lowerName = fname.toLowerCase();
		}
		
		catch(NullPointerException ex){
			System.out.println("String is null.");
		}
		finally {
			System.out.println("First name: "+fname);
		}
	}
}
