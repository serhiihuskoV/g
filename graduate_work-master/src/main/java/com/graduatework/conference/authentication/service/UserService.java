package com.graduatework.conference.authentication.service;

import com.graduatework.conference.authentication.model.User;
import com.graduatework.conference.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public void updateUser(User user, int userId) {
        userRepository.updateUser(user, userId);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public User getUserByUserId(int userId) {
        return userRepository.getUserByUserId(userId);
    }
}
