package com.wipro.basic;



public class Exercise18 
{
	public static void main(String[] args) {
		
//		String s = "rotor";
//		boolean flag = false;
//		
//		int n = s.length();
//		for(int i = 0;i<n/2;i++) {
//			if((s.charAt(i))==(s.charAt(n-1-i))) {
//				flag = true;
//				break;
//			}
//		}
//		
//		if(flag == true) {
//			System.out.println("String is palindrome");
//		}
//		else {
//			System.out.println("String is not palindrome");
//		}
		
		String s = "rotor";
		String n = "";
		
		for(int i = s.length()-1;i>=0;i--) {
			n+=s.charAt(i);
		}
		
		if(s.equals(n)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not palindrome");
		}
	}
	
	
}
