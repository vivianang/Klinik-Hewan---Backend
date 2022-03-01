package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddEmployeeRequestDto;
import com.project.AppKlinik.dto.UpdateEmployeeRequestDto;
import com.project.AppKlinik.model.Employee;
import com.project.AppKlinik.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(AddEmployeeRequestDto requestDto) {
        return employeeRepository.saveAndFlush(Employee.builder()
                .name(requestDto.getName())
                .build());
    }

    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid Employee id: " + id));
    }

    public Employee updateEmployee(UpdateEmployeeRequestDto requestDto) {
        Employee employeeToUpdate = getEmployeeById(requestDto.getId());
        employeeToUpdate.setName(requestDto.getName());
        return employeeRepository.saveAndFlush(employeeToUpdate);
    }

    public String deleteEmployee(UUID id) {
        Employee employeeToDelete = getEmployeeById(id);
        employeeRepository.delete(employeeToDelete);
        return "Success delete Employee";
    }
}
