package com.example.demo.model;

import java.time.LocalDate;

public class GeneratedShiftSchedule {

    private Long id;
    private LocalDate shiftDate;
    private ShiftTemplate shiftTemplate;
    private Department department;
    private Employee employee;

    public Long getId() { return id; }

    public LocalDate getShiftDate() { return shiftDate; }
    public void setShiftDate(LocalDate shiftDate) { this.shiftDate = shiftDate; }

    public ShiftTemplate getShiftTemplate() { return shiftTemplate; }
    public void setShiftTemplate(ShiftTemplate shiftTemplate) { this.shiftTemplate = shiftTemplate; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
