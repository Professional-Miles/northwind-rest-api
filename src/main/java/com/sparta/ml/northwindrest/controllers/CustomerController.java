package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.entities.CustomerEntity;
import com.sparta.ml.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/northwind/customers")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(@RequestParam(required = false) String name){
        if (name == null){
            return customerRepository.findAll();
        }
        List<CustomerEntity> foundCustomers = new ArrayList<>();
        for (CustomerEntity customerEntity: customerRepository.findAll()){
            if (customerEntity.getContactName().contains(name)){
                foundCustomers.add(customerEntity);
            }
        }
        return foundCustomers;
    }


}
