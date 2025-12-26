package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Department;

public interface DepartmentRepository {

    boolean existsByName(String name);

    Optional<Department> findById(Long id);

    List<Department> findAll();

    Department save(Department department);

    void delete(Department department);
}
