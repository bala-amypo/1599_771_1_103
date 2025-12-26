package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.service.AvailabilityService;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping("/{employeeId}")
    public EmployeeAvailability create(@PathVariable Long employeeId,
                                       @RequestBody EmployeeAvailability availability) {
        return availabilityService.create(employeeId, availability);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeAvailability> getByEmployee(@PathVariable Long employeeId) {
        return availabilityService.getByEmployee(employeeId);
    }

    @GetMapping("/date/{date}")
    public List<EmployeeAvailability> getByDate(@PathVariable LocalDate date) {
        return availabilityService.getByDate(date);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        availabilityService.delete(id);
    }
}
