package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate availableDate;
    private Boolean available;
    public EmployeeAvailability(){}
    public EmployeeAvailability(Long id, LocalDate availableDate, Boolean available) {
        this.id = id;
        this.availableDate = availableDate;
        this.available = available;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getAvailableDate() {
        return availableDate;
    }
    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    
}
