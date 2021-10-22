package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.dto.ProductDTO;
import com.sparta.ml.northwindrest.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/northwind/products")
    @ResponseBody
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value="/northwind/products", params={"productId"})
    @ResponseBody
    public List<ProductDTO> getProductsById(@RequestParam Integer productId) {
        return productService.getProductsByProductId(productId);
    }

    @GetMapping(value="/northwind/products", params={"supplierId"})
    @ResponseBody
    public List<ProductDTO> getProductsBySupplierId(@RequestParam Integer supplierId) {
            return productService.getProductsBySupplier(supplierId);
    }

    @GetMapping(value="/northwind/products", params={"categoryId"})
    @ResponseBody
    public List<ProductDTO> getProductsByCategoryId(@RequestParam Integer categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping(value="/northwind/products", params = {"name"})
    @ResponseBody
    public List<ProductDTO> getProductsByName(@RequestParam(required = false) String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/northwind/products/available")
    @ResponseBody
    public List<ProductDTO> getAvailableProducts() {
        return productService.getAvailableProducts();
    }

    @GetMapping("/northwind/products/discontinued")
    @ResponseBody
    public List<ProductDTO> getDiscontinuedProducts() {
        return productService.getDiscontinuedProducts();
    }

}
