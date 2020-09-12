package com.udacity.jdnd.course3.critter.schedule.service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleByPetId(Long petId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(s -> s.getPets()
                        .stream()
                        .map(Pet::getId)
                        .collect(Collectors.toList())
                .contains(petId))
                .collect(Collectors.toList());
    }

    public List<Schedule> getScheduleByPetIds(List<Long> petIds) {
        return scheduleRepository.findAll()
                .stream()
                .filter(s -> s.getPets()
                    .stream()
                    .map(Pet::getId)
                    .collect(Collectors.toList())
                .containsAll(petIds))
                .collect(Collectors.toList());
    }

    public List<Schedule> getScheduleByEmployeeId(Long employeeId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(s -> s.getEmployees()
                    .stream()
                    .map(Employee::getId)
                    .collect(Collectors.toList())
                .contains(employeeId))
                .collect(Collectors.toList());
    }
}
