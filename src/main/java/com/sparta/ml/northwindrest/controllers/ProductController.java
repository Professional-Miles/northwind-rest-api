package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.entities.ProductEntity;
import com.sparta.ml.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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


}
