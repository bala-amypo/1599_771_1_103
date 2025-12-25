package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ShiftTemplateRepository shiftTemplateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;
    private final DepartmentRepository departmentRepository;

    public ScheduleServiceImpl(ShiftTemplateRepository shiftTemplateRepository,
                               AvailabilityRepository availabilityRepository,
                               EmployeeRepository employeeRepository,
                               GeneratedShiftScheduleRepository scheduleRepository,
                               DepartmentRepository departmentRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
        this.scheduleRepository = scheduleRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<GeneratedShiftSchedule> result = new ArrayList<>();

        for (Department dept : departmentRepository.findAll()) {
            List<ShiftTemplate> templates = shiftTemplateRepository.findByDepartment_Id(dept.getId());

            for (ShiftTemplate template : templates) {
                List<EmployeeAvailability> availableList =
                        availabilityRepository.findByAvailableDateAndAvailable(date, true);

                for (EmployeeAvailability ea : availableList) {
                    Employee emp = ea.getEmployee();

                    if (emp.getSkills() != null &&
                        template.getRequiredSkills() != null &&
                        emp.getSkills().contains(template.getRequiredSkills())) {

                        GeneratedShiftSchedule schedule = new GeneratedShiftSchedule();
                        schedule.setShiftDate(date);
                        schedule.setStartTime(template.getStartTime());
                        schedule.setEndTime(template.getEndTime());
                        schedule.setShiftTemplate(template);
                        schedule.setDepartment(dept);
                        schedule.setEmployee(emp);

                        result.add(scheduleRepository.save(schedule));
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}
