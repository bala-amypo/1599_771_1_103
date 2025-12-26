package com.example.demo.model;

import java.time.LocalDate;

public class EmployeeAvailability {
    private Long id;
    private Employee employee;
    private LocalDate availableDate;
    private Boolean available;

    public EmployeeAvailability() {}

    public EmployeeAvailability(Employee e, LocalDate d, Boolean a) {
        this.employee = e;
        this.availableDate = d;
        this.available = a;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public LocalDate getAvailableDate() { return availableDate; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}
