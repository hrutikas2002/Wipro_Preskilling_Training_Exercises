package com.wipro.ecom.service;

import java.util.List;
import java.util.Optional;

import com.wipro.ecom.entity.User;

public interface UserService {
	public User registerUser(User user);
	public List<User> getAllUsers();
	 public User getUserById(int id);
	 public User updateUser(User user);
	 public void deleteUser(int id);
	 public String login(String userId, String password);
	 public void logout(String userId);
}
