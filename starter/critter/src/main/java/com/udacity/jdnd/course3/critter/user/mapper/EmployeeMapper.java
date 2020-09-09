package com.udacity.jdnd.course3.critter.user.mapper;

import com.udacity.jdnd.course3.critter.user.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee DTOToEntity(EmployeeDTO employeeDTO) {
        Employee employeeEntity = new Employee();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setDaysAvailable(employeeDTO.getDaysAvailable());
        employeeEntity.setEmployeeSkills(employeeDTO.getSkills());
        return employeeEntity;
    }

    public EmployeeDTO entityToDTO(Employee employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDaysAvailable(employeeEntity.getDaysAvailable());
        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setName(employeeEntity.getName());
        employeeDTO.setSkills(employeeEntity.getEmployeeSkills());
        return employeeDTO;
    }

    public List<EmployeeDTO> entitiesToDTOs(List<Employee> employees) {
        return employees
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

}
