package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EmployeeAvailability;

public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {

    Optional<EmployeeAvailability> findByEmployee_IdAndAvailableDate(Long employeeId, LocalDate date);

    List<EmployeeAvailability> findByAvailableDateAndAvailable(LocalDate date, boolean available);

    List<EmployeeAvailability> findByEmployee_Id(Long employeeId);
}
