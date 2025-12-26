package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.EmployeeAvailability;

public interface AvailabilityRepository {

    Optional<EmployeeAvailability> findByEmployee_IdAndAvailableDate(Long employeeId, LocalDate date);

    List<EmployeeAvailability> findByAvailableDateAndAvailable(LocalDate date, boolean available);

    List<EmployeeAvailability> findByEmployee_Id(Long employeeId);

    Optional<EmployeeAvailability> findById(Long id);

    EmployeeAvailability save(EmployeeAvailability availability);

    void delete(EmployeeAvailability availability);
}
