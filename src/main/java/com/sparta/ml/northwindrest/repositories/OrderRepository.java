package com.sparta.ml.northwindrest.repositories;

import com.sparta.ml.northwindrest.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}