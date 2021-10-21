package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.entities.EmployeeEntity;
import com.sparta.ml.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;;
    }

    @GetMapping("/northwind/employees")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/northwind/employees/{id}")
    public Optional<EmployeeEntity> getEmployeesById(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }

}
