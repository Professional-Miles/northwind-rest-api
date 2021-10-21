package com.sparta.ml.northwindrest.repositories;

import com.sparta.ml.northwindrest.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}