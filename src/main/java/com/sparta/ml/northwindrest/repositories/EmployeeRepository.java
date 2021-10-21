package com.sparta.ml.northwindrest.repositories;

import com.sparta.ml.northwindrest.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}