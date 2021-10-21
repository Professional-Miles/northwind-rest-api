package com.sparta.ml.northwindrest.repositories;

import com.sparta.ml.northwindrest.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}