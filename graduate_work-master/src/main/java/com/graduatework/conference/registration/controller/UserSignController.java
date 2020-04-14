package com.graduatework.conference.registration.controller;

import com.graduatework.conference.registration.model.UserRegistration;
import com.graduatework.conference.registration.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class UserSignController {
    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserSignController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public void register(@RequestBody UserRegistration userRegistration) {
        userRegistrationService.register(userRegistration);
    }
}