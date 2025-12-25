package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ShiftTemplate;

public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate, Long> {

    Optional<ShiftTemplate> findByTemplateNameAndDepartment_Id(String templateName, Long departmentId);

    List<ShiftTemplate> findByDepartment_Id(Long departmentId);
}
