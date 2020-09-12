package com.udacity.jdnd.course3.critter.schedule.mapper;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.service.PetService;
import com.udacity.jdnd.course3.critter.schedule.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleMapper {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    PetService petService;

    public Schedule DTOToEntity(ScheduleDTO scheduleDTO) {
        Schedule scheduleEntity = new Schedule();
        scheduleEntity.setDate(scheduleDTO.getDate());
        scheduleEntity.setEmployees(employeeService.getEmployeesByIds(scheduleDTO.getEmployeeIds()));
        scheduleEntity.setPets(petService.getPetsByIds(scheduleDTO.getPetIds()));
        scheduleEntity.setActivities(scheduleDTO.getActivities());
        return scheduleEntity;
    }

    public ScheduleDTO entityToDTO(Schedule scheduleEntity) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setDate(scheduleEntity.getDate());
        scheduleDTO.setEmployeeIds(scheduleEntity.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        scheduleDTO.setActivities(scheduleEntity.getActivities());
        scheduleDTO.setPetIds(scheduleEntity.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return scheduleDTO;
    }

    public List<ScheduleDTO> entitiesToDTOs(List<Schedule> scheduleEntities) {
        return scheduleEntities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}
