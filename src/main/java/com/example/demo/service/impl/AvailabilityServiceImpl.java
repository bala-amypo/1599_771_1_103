package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeAvailability create(Long employeeId,
                                       EmployeeAvailability availability) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        availabilityRepository
                .findByEmployee_IdAndAvailableDate(
                        employeeId, availability.getAvailableDate())
                .ifPresent(a -> {
                    throw new RuntimeException("Availability already exists");
                });

        availability.setEmployee(employee);
        return availabilityRepository.save(availability);
    }

    @Override
    public EmployeeAvailability update(Long id,
                                       EmployeeAvailability availability) {

        EmployeeAvailability existing =
                availabilityRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Availability not found"));

        existing.setAvailable(availability.getAvailable());
        existing.setAvailableDate(availability.getAvailableDate());

        return availabilityRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        EmployeeAvailability availability =
                availabilityRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Availability not found"));

        availabilityRepository.delete(availability);
    }

    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return availabilityRepository
                .findByAvailableDateAndAvailable(date, true);
    }

    @Override
    public List<EmployeeAvailability> getByEmployee(Long employeeId) {
        return availabilityRepository.findByEmployee_Id(employeeId);
    }
}
