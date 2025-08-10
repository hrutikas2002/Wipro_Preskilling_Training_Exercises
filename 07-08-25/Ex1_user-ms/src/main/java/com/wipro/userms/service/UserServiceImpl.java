package com.wipro.userms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.userms.client.NotificationClient;
import com.wipro.userms.dto.NotificationDTO;
import com.wipro.userms.entity.User;
import com.wipro.userms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationClient notificationClient;

    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        notificationClient.sendNotification(new NotificationDTO(savedUser, "Created"));
        return savedUser;
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setAddress(user.getAddress());
        User updatedUser = userRepository.save(existingUser);
        notificationClient.sendNotification(new NotificationDTO(updatedUser, "Updated"));
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        notificationClient.sendNotification(new NotificationDTO(user, "Deleted"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
