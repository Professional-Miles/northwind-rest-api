package com.sparta.ml.northwindrest.services;

import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.dto.ErrorDTO;
import com.sparta.ml.northwindrest.dto.ProductDTO;
import com.sparta.ml.northwindrest.entities.ProductEntity;
import com.sparta.ml.northwindrest.errorhandling.ErrorControl;
import com.sparta.ml.northwindrest.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public List<DTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    public List<DTO> getProductsByProductId(Integer productId) {
        List<DTO> thisList =
                productRepository
                        .findAll()
                        .stream()
                        .filter(productEntity -> productEntity.getId().equals(productId))
                        .map(this::convertToProductDTO)
                        .collect(Collectors.toList());

        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }

    public List<DTO> getProductsBySupplier(Integer supplierId) {
        List<DTO> thisList =
                productRepository
                        .findAll()
                        .stream()
                        .filter(productEntity -> productEntity.getSupplier().getId().equals(supplierId))
                        .map(this::convertToProductDTO)
                        .collect(Collectors.toList());

        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }

    public List<DTO> getProductsByCategory(Integer categoryId) {
        List<DTO> thisList =
                productRepository
                        .findAll()
                        .stream()
                        .filter(productEntity -> productEntity.getCategory().getId().equals(categoryId))
                        .map(this::convertToProductDTO)
                        .collect(Collectors.toList());
        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }

    public List<DTO> getProductsByName(String name) {
        if (name != null) {
            return productRepository
                    .findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getProductName().contains(name))
                    .map(this::convertToProductDTO)
                    .collect(Collectors.toList());
        }
        return getAllProducts();
    }

    public List<DTO> getAvailableProducts() {
        List<DTO> thisList =
                productRepository
                        .findAll()
                        .stream()
                        .filter(productEntity -> productEntity.getDiscontinued().equals(false))
                        .map(this::convertToProductDTO)
                        .collect(Collectors.toList());
        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }

    public List<DTO> getDiscontinuedProducts() {
        List<DTO> thisList =
         productRepository
                .findAll()
                .stream()
                .filter(productEntity -> productEntity.getDiscontinued().equals(true))
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }

    private ProductDTO convertToProductDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setSupplierName(productEntity.getSupplierName());
        productDTO.setCategoryName(productEntity.getCategoryName());
        productDTO.setQuantityPerUnit(productEntity.getQuantityPerUnit());
        productDTO.setUnitPrice(productEntity.getUnitPrice());
        productDTO.setDiscontinued(productEntity.getDiscontinued());

        return productDTO;
    }

}
