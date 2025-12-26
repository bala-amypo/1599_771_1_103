package com.example.demo.model;

import java.time.LocalDate;

public class GeneratedShiftSchedule {
    private Long id;
    private LocalDate shiftDate;
    private ShiftTemplate shiftTemplate;
    private Department department;
    private Employee employee;

    public void setShiftDate(LocalDate shiftDate) { this.shiftDate = shiftDate; }
    public void setShiftTemplate(ShiftTemplate shiftTemplate) { this.shiftTemplate = shiftTemplate; }
    public void setDepartment(Department department) { this.department = department; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public LocalDate getShiftDate() { return shiftDate; }
}
