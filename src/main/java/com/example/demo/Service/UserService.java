package com.example.demo.service;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
}
