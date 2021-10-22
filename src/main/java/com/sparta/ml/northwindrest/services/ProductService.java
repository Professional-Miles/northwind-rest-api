package com.sparta.ml.northwindrest.services;

import com.sparta.ml.northwindrest.dto.ProductDTO;
import com.sparta.ml.northwindrest.entities.ProductEntity;
import com.sparta.ml.northwindrest.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Resource
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        return ((List<ProductDTO>) productRepository
                .findAll()
                .stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
    }

    public List<ProductDTO> getProductsByProductId(Integer productId){
        return ((List<ProductDTO>) productRepository
                .findAll()
                .stream()
                .filter(productEntity -> productEntity.getId().equals(productId))
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
    }

    public List<ProductDTO> getProductsBySupplier(Integer supplierId){
        return ((List<ProductDTO>) productRepository
                .findAll()
                .stream()
                .filter(productEntity -> productEntity.getSupplier().getId().equals(supplierId))
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
    }

    public List<ProductDTO> getProductsByCategory(Integer categoryId){
        return ((List<ProductDTO>) productRepository
                .findAll()
                .stream()
                .filter(productEntity -> productEntity.getCategory().getId().equals(categoryId))
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
    }

    public List<ProductDTO> getProductsByName(String name){
        if (name != null){
            return ((List<ProductDTO>) productRepository
                    .findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getProductName().contains(name))
                    .map(this::convertToProductDTO)
                    .collect(Collectors.toList()));
        }
        return getAllProducts();
    }

    public List<ProductDTO> getAvailableProducts(){
            return ((List<ProductDTO>) productRepository
                    .findAll()
                    .stream()
                    .filter(productEntity -> productEntity.getDiscontinued().equals(false))
                    .map(this::convertToProductDTO)
                    .collect(Collectors.toList()));
    }

    public List<ProductDTO> getDiscontinuedProducts(){
        return ((List<ProductDTO>) productRepository
                .findAll()
                .stream()
                .filter(productEntity -> productEntity.getDiscontinued().equals(true))
                .map(this::convertToProductDTO)
                .collect(Collectors.toList()));
    }


    private ProductDTO convertToProductDTO(ProductEntity productEntity){
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
