package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication Endpoints")
public class AuthController {
    @Autowired
    UserService userserv;
    @PostMapping("/register")
    public User register(User user) {
        return userserv.register(user);
    }
    @PostMapping("/login")
    public String login(String email, String password) {
        User user = userserv.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }
}
