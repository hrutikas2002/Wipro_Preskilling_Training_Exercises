package com.wipro.junit;

public class CheckCase {
	public boolean isUpperCase(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.equals(str.toUpperCase());
	}
}
