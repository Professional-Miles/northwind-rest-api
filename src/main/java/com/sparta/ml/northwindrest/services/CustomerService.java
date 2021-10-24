package com.sparta.ml.northwindrest.services;

import com.sparta.ml.northwindrest.dto.CustomerDTO;
import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.dto.ProductDTO;
import com.sparta.ml.northwindrest.entities.CustomerEntity;
import com.sparta.ml.northwindrest.entities.ProductEntity;
import com.sparta.ml.northwindrest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    public List<DTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(this::convertToCustomerDTO)
                .collect(Collectors.toList());
    }


    private CustomerDTO convertToCustomerDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerEntity.getId());
        customerDTO.setCompanyName(customerEntity.getCompanyName());
        customerDTO.setContactName(customerEntity.getContactName());
        customerDTO.setContactTitle(customerEntity.getContactTitle());
        customerDTO.setCity(customerEntity.getCity());
        customerDTO.setCountry(customerEntity.getCountry());

        return customerDTO;
    }



}
