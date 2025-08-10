package com.wipro.springbootmvc.model;

public class User {
	String username;
	String uemail;
	String uphone;
	public User(String username, String uemail, String uphone) {
		super();
		this.username = username;
		this.uemail = uemail;
		this.uphone = uphone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", uemail=" + uemail + ", uphone=" + uphone + "]";
	}
}
