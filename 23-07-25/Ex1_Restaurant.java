package com.wipro.oops;

public class Restaurant {
	String name;
	String address;
	String contactNo;
	int rating;
	
	
	public Restaurant() {
	}

	public Restaurant(String name, String address, String contactNo, int rating) {
		super();
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.rating = rating;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", address=" + address + ", contactNo=" + contactNo + ", rating=" + rating
				+ "]";
	}
	
}
