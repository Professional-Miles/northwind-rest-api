package com.sparta.ml.northwindrest.repositories;

import com.sparta.ml.northwindrest.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {


}