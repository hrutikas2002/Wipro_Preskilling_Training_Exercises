package com.wipro.userms.service;

import java.util.List;

import com.wipro.userms.entity.User;

public interface UserService {
	public User createUser(User user);
	public User updateUser(Long id, User user);
	public void deleteUser(Long id);
	public List<User> getAllUsers();
	public User getUserById(Long id);
}
