package com.example.demo.service;

import java.util.List;

public interface ScheduleService {
    List<GeneratedShiftSchedule> generateForDate(LocalDate date);
    List<GeneratedShiftSchedule> getByDate(LocalDate date);
}
