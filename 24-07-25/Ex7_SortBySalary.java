package com.wipro.collection;

import java.util.Comparator;

public class SortBySalary implements Comparator<Employee>
{

	@Override
	public int compare(Employee o1, Employee o2) {
		Double d1=Double.valueOf(o1.getSalary());
		Double d2=Double.valueOf(o2.getSalary());
		return d1.compareTo(d2);
	}

}
