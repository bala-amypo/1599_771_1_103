package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.GeneratedShiftSchedule;

public interface GeneratedShiftScheduleRepository {

    GeneratedShiftSchedule save(GeneratedShiftSchedule schedule);

    List<GeneratedShiftSchedule> findByShiftDate(LocalDate date);
}
