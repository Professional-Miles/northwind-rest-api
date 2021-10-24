package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/northwind/employees")
    @ResponseBody
    public List<DTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(value="/northwind/employees", params={"employeeId"})
    @ResponseBody
    public List<DTO> getEmployeesById(@RequestParam Integer employeeId) {
        return employeeService.getEmployeeByEmployeeId(employeeId);
    }


}
