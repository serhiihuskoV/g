package com.graduatework.conference.config;

import com.graduatework.conference.authentication.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    @GetMapping
    public String getIndex(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("name", user.getName());
            model.addAttribute("username", user.getUsername());
            model.addAttribute("surname", user.getSurname());
            model.addAttribute("email", user.getEmail());
        } else {
            model.addAttribute("name", "guest");
        }
        return "index.html";
    }
}