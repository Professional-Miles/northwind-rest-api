package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.entities.CategoryEntity;
import com.sparta.ml.northwindrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/northwind/categories")
    public List<CategoryEntity> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/northwind/categories/{id}")
    public Optional<CategoryEntity> getProductsById(@PathVariable Integer id){
        return categoryRepository.findById(id);
    }




}
