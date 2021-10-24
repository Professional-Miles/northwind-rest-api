package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.dto.CustomerDTO;
import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.entities.CustomerEntity;
import com.sparta.ml.northwindrest.repositories.CustomerRepository;
import com.sparta.ml.northwindrest.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/northwind/customers")
    @ResponseBody
    public List<DTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value="/northwind/customers", params={"customerId"})
    @ResponseBody
    public List<DTO> getCustomerById(@RequestParam String customerId) {
        return customerService.getCustomersByCustomerId(customerId);
    }


}
