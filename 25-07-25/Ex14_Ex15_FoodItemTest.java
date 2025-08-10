package com.wipro.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FoodItemTest {
	public static void main(String[] args) 
	{
		FoodItem f1 = new FoodItem("Noodles", "Veg", "Chinese", 250);
		FoodItem f2 = new FoodItem("Puranpoli", "Veg", "Indian", 120);
		FoodItem f3 = new FoodItem("Chiken Biryani", "Non Veg", "Indian", 200);
		FoodItem f4 = new FoodItem("Fried Rice", "Veg", "Chinese", 130);
		FoodItem f5 = new FoodItem("Pizza", "Veg", "Italian", 300);
		FoodItem f6 = new FoodItem("Roll", "Veg", "Chinese", 180);
		FoodItem f7 = new FoodItem("Mutton Rogan Josh", "Non Veg", "Indian", 250);

		List<FoodItem> foodList = new ArrayList<>();
		foodList.add(f1);
		foodList.add(f2);
		foodList.add(f3);
		foodList.add(f4);
		foodList.add(f5);
		foodList.add(f6);
		foodList.add(f7);


		List<FoodItem> chineseFood = foodList.stream()
				.filter(f -> f.getCuisine().equalsIgnoreCase("Chinese"))
				.collect(Collectors.toList());

		System.out.println("Chinese Food Items:"+chineseFood);

		Comparator<FoodItem> byPrice = (o1, o2) -> 
		{
			Double d1 = Double.valueOf(o1.getPrice());
	        Double d2 = Double.valueOf(o2.getPrice());
	        return d1.compareTo(d2);
		};
		
		FoodItem mostExpensiveChinese = foodList.stream()
			    .filter(f -> f.getCuisine().equalsIgnoreCase("Chinese"))
			    .max(byPrice)
			    .orElse(null); 
		
		System.out.println("Expensive dish: "+mostExpensiveChinese);
	}
}
