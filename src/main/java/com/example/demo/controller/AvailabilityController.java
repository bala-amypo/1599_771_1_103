package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.service.AvailabilityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping("/{employeeId}")
    public EmployeeAvailability create(@PathVariable Long employeeId,
                                       @RequestBody
                                       EmployeeAvailability availability) {
        return availabilityService.create(employeeId, availability);
    }

    @PutMapping("/{id}")
    public EmployeeAvailability update(@PathVariable Long id,
                                       @RequestBody
                                       EmployeeAvailability availability) {
        return availabilityService.update(id, availability);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        availabilityService.delete(id);
        return "Availability deleted";
    }

    @GetMapping("/date/{date}")
    public List<EmployeeAvailability> getByDate(
            @PathVariable LocalDate date) {
        return availabilityService.getByDate(date);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeAvailability> getByEmployee(
            @PathVariable Long employeeId) {
        return availabilityService.getByEmployee(employeeId);
    }
}
