package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.entities.CustomerEntity;
import com.sparta.ml.northwindrest.entities.ProductEntity;
import com.sparta.ml.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/northwind/products")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/northwind/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id){
        return productRepository.findById(id);
    }

    @GetMapping("/northwind/products/discontinued")
    public List<ProductEntity> getAllDiscontinuedProducts(){
        List<ProductEntity> foundCustomers = new ArrayList<>();
        for (ProductEntity productEntity: productRepository.findAll()){
            if (productEntity.getDiscontinued().equals(true)){
                foundCustomers.add(productEntity);
            }
        }
        return foundCustomers;
    }




}
