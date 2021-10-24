package com.sparta.ml.northwindrest.services;

import com.sparta.ml.northwindrest.dto.CustomerDTO;
import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.entities.CustomerEntity;
import com.sparta.ml.northwindrest.errorhandling.ErrorControl;
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

    public List<DTO> getCustomersByCustomerId(String customerId) {
        List<DTO> thisList =
                customerRepository
                        .findAll()
                        .stream()
                        .filter(customerEntity -> customerEntity.getId().contains(customerId))
                        .map(this::convertToCustomerDTO)
                        .collect(Collectors.toList());

        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }

    public List<DTO> getCustomersByContactName(String name) {
        List<DTO> thisList =
                customerRepository
                        .findAll()
                        .stream()
                        .filter(customerEntity -> customerEntity.getContactName().contains(name))
                        .map(this::convertToCustomerDTO)
                        .collect(Collectors.toList());

        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
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
