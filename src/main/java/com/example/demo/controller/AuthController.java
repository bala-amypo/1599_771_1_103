package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.config.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User u = userService.findByEmail(user.getEmail());
        String token = jwtUtil.generateToken(u.getEmail(), u.getRole(), u.getId());
        return ResponseEntity.ok(token);
    }
}
