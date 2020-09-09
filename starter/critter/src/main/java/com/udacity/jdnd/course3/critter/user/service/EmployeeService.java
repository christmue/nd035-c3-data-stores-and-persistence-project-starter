package com.udacity.jdnd.course3.critter.user.service;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    public List<Employee> getEmployeesByService(Set<EmployeeSkill> requiredSkills, LocalDate date) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .filter(e -> e.getEmployeeSkills().containsAll(requiredSkills))
                .filter(e -> e.getDaysAvailable().contains(date.getDayOfWeek()))
                .collect(Collectors.toList());
    }


}
