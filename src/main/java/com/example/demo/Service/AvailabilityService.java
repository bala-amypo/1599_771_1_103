package com.example.demo.service;

import java.util.List;

public interface AvailabilityService {
    EmployeeAvailability create(EmployeeAvailability availability);
    EmployeeAvailability update(Long id, EmployeeAvailability availability);
    void delete(Long id);
    List<EmployeeAvailability> getByDate(LocalDate date);
}
