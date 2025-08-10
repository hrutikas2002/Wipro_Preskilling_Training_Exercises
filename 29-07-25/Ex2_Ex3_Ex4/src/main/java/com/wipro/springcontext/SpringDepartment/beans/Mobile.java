package com.wipro.springcontext.SpringDepartment.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile 
{
	private Display display;

	@Autowired
	public Mobile(Display display) {
		super();
		this.display = display;
	}

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	@Override
	public String toString() {
		return "Mobile [display=" + display + "]";
	}
	
}
