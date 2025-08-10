package com.wipro.springcontext.SpringDepartment.beans;

import org.springframework.stereotype.Component;

@Component
public class Display 
{
	int size;

	public Display(int size) {
		super();
		this.size = size;
	}

	public Display() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Display [size=" + size + "]";
	}
	
}
