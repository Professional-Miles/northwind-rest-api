package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.services.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value="customers", description="Operations pertaining to the products table.")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/northwind/customers")
    @ResponseBody
    public List<DTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value="/northwind/customers/", params={"customerId"})
    @ResponseBody
    public List<DTO> getCustomerById(@RequestParam String customerId) {
        return customerService.getCustomersByCustomerId(customerId);
    }

    @GetMapping(value="/northwind/customers/", params={"contactName"})
    @ResponseBody
    public List<DTO> getCustomerByContactName(@RequestParam String contactName) {
        return customerService.getCustomersByContactName(contactName);
    }


}
