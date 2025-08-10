package com.wipro.junit;

//Create a testcase to check that while trying to make uppercase of  a null string will throw null pointer exception.

public class CheckNullString {
	public void checkNull(String str) {
		str.toUpperCase(); 
	}
}
