package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.entities.ProductEntity;
import com.sparta.ml.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/northwind/products")
    @ResponseBody
    public List<ProductEntity> getAllProducts(@RequestParam(required = false) String name) {
        if (name == null) {
            return productRepository.findAll();
        }
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getProductName().contains(name))
                .collect(Collectors.toList());
    }

    @GetMapping("/northwind/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("/northwind/products/discontinued")
    public List<ProductEntity> getAllDiscontinuedProducts() {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getDiscontinued().equals(true))
                .collect(Collectors.toList());
    }

    @GetMapping("/northwind/products/available")
    public List<ProductEntity> getAllAvailableProducts() {
        return productRepository.findAll()
                .stream()
                .filter(productEntity -> productEntity.getDiscontinued().equals(false))
                .collect(Collectors.toList());
    }
}
