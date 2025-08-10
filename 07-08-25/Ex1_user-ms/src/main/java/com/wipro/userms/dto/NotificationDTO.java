package com.wipro.userms.dto;

import com.wipro.userms.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
	private User user;
	private String action;
}
