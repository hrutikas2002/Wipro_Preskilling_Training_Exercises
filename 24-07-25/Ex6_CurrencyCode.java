package com.wipro.collection;

import java.util.Map;
import java.util.TreeMap;

public class CurrencyCode 
{
	public static void main(String[] args) 
	{
		Map<String, String> currency = new TreeMap<>();
        currency.put("USD", "United States Dollar");
        currency.put("INR", "Indian Rupee");
        currency.put("EUR", "Euro");
        currency.put("JPY", "Japanese Yen");
        currency.put("GBP", "British Pound");

        for (Map.Entry<String, String> entry : currency.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
