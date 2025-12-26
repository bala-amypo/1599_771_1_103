package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;

public class AvailabilityController {

    private final AvailabilityService availabilityService;
    private final EmployeeRepository employeeRepository;

    public AvailabilityController(AvailabilityService availabilityService,
                                  EmployeeRepository employeeRepository) {
        this.availabilityService = availabilityService;
        this.employeeRepository = employeeRepository;
    }

    public Response<List<EmployeeAvailability>> byDate(String date) {
        LocalDate d = LocalDate.parse(date);
        return new Response<>(availabilityService.getByDate(d));
    }
}
