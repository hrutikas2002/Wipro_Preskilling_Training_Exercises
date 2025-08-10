package com.wipro.notificationms.dto;

public class NotificationDTO {
    private UserDTO user;
    private String action;
	public NotificationDTO(UserDTO user, String action) {
		super();
		this.user = user;
		this.action = action;
	}
	public NotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
