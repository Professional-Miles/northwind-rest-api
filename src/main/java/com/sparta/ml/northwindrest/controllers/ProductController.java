package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.dto.ProductDTO;
import com.sparta.ml.northwindrest.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


@RestController
@Api(value="products", description="Operations pertaining to the products table.")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/northwind/products")
    @ResponseBody
    public List<DTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value="/northwind/products/productId/{productId}")
    @ResponseBody
    public List<ProductDTO> getProductsById(@PathVariable Integer productId) {
        return productService.getProductsByProductId(productId);
    }

    @GetMapping(value="/northwind/products/supplierId/{supplierId}")
    @ResponseBody
    public List<DTO> getProductsBySupplierId(@PathVariable Integer supplierId) {
            return productService.getProductsBySupplier(supplierId);
    }

    @GetMapping(value="/northwind/products/categoryId/{categoryId}")
    @ResponseBody
    public List<DTO> getProductsByCategoryId(@PathVariable Integer categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping(value="/northwind/products/name/{name}")
    @ResponseBody
    public List<DTO> getProductsByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/northwind/products/available")
    @ResponseBody
    public List<DTO> getAvailableProducts() {
        return productService.getAvailableProducts();
    }

    @GetMapping("/northwind/products/discontinued")
    @ResponseBody
    public List<DTO> getDiscontinuedProducts() {
        return productService.getDiscontinuedProducts();
    }

}
