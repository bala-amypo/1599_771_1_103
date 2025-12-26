package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Employee {

    private Long id;
    private String fullName;
    private String email;
    private String role;
    private String skills;
    private Integer maxWeeklyHours;
    private LocalDateTime createdAt;

    public Employee() {}

    public Employee(String fullName, String email, String role, String skills, Integer maxWeeklyHours) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
        this.createdAt = LocalDateTime.now();
    }

    public Set<String> getSkills() {
        return Arrays.stream(skills.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Integer getMaxWeeklyHours() { return maxWeeklyHours; }
    public void setMaxWeeklyHours(Integer maxWeeklyHours) { this.maxWeeklyHours = maxWeeklyHours; }

    public void setSkills(String skills) { this.skills = skills; }
}
