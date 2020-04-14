package com.graduatework.conference.registration.service;

import com.graduatework.conference.authentication.model.User;
import com.graduatework.conference.authentication.service.UserService;
import com.graduatework.conference.registration.model.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public UserRegistrationService(PasswordEncoder passwordEncoder,
                                   UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public void register(UserRegistration userRegistration) {
        userService.saveUser(registerUser(userRegistration));
    }

    private User registerUser(UserRegistration userRegistration) {
        User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setName(userRegistration.getName());
        user.setSurname(userRegistration.getSurname());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.setEmail(userRegistration.getEmail());
        return user;
    }
}