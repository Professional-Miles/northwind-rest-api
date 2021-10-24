package com.sparta.ml.northwindrest.services;

import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.dto.EmployeeDTO;
import com.sparta.ml.northwindrest.entities.EmployeeEntity;
import com.sparta.ml.northwindrest.errorhandling.ErrorControl;
import com.sparta.ml.northwindrest.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Resource
    private EmployeeRepository employeeRepository;

    public List<DTO> getAllEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<DTO> getEmployeeByEmployeeId(Integer employeeId) {
        List<DTO> thisList =
                employeeRepository
                        .findAll()
                        .stream()
                        .filter(employeeEntity -> employeeEntity.getId().equals(employeeId))
                        .map(this::convertToEmployeeDTO)
                        .collect(Collectors.toList());

        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }



    private EmployeeDTO convertToEmployeeDTO(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setTitleOfCourtesy(employeeEntity.getTitleOfCourtesy());
        employeeDTO.setFirstName(employeeEntity.getFirstName());
        employeeDTO.setLastName(employeeEntity.getLastName());
        employeeDTO.setTitle(employeeEntity.getTitle());
        employeeDTO.setCity(employeeEntity.getCity());
        employeeDTO.setCountry(employeeEntity.getCity());
        employeeDTO.setSalary(employeeEntity.getSalary());

        return employeeDTO;
    }

}
