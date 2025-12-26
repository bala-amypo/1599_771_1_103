package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ShiftTemplate;

public interface ShiftTemplateRepository {

    Optional<ShiftTemplate> findByTemplateNameAndDepartment_Id(String templateName, Long departmentId);

    List<ShiftTemplate> findByDepartment_Id(Long departmentId);

    List<ShiftTemplate> findAll();

    ShiftTemplate save(ShiftTemplate shiftTemplate);
}
