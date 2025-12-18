package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private Integer maxWeeklyHours;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Default constructor (JPA + default role)
    public Employee() {
        this.role = "STAFF";
    }

    // Parameterized constructor (includes id as per your style)
    public Employee(Long id,
                    String fullName,
                    String email,
                    String role,
                    String skills,
                    Integer maxWeeklyHours,
                    LocalDateTime createdAt) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = (role == null || role.isEmpty()) ? "STAFF" : role;
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
        this.createdAt = createdAt;
    }

    // Auto-generate createdAt
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getSkills() { return skills; }
    public Integer getMaxWeeklyHours() { return maxWeeklyHours; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }

    public void setRole(String role) {
        this.role = (role == null || role.isEmpty()) ? "STAFF" : role;
    }

    public void setSkills(String skills) { this.skills = skills; }

    public void setMaxWeeklyHours(Integer maxWeeklyHours) {
        this.maxWeeklyHours = maxWeeklyHours;
    }
}
