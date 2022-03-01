package com.project.AppKlinik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddEmployeeRequestDto;
import com.project.AppKlinik.dto.UpdateEmployeeRequestDto;
import com.project.AppKlinik.model.Employee;
import com.project.AppKlinik.service.EmployeeService;

@RequestMapping("employee")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody @Valid AddEmployeeRequestDto requestDto) {
        return employeeService.addEmployee(requestDto);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody @Valid UpdateEmployeeRequestDto requestDto) {
        return employeeService.updateEmployee(requestDto);
    }

    @DeleteMapping
    public String deleteEmployee(@RequestParam UUID id) {
        return employeeService.deleteEmployee(id);
    }
}
