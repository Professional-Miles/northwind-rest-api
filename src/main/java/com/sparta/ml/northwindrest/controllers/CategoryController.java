package com.sparta.ml.northwindrest.controllers;

import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/northwind/categories")
    @ResponseBody
    public List<DTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/northwind/categories", params = {"categoryId"})
    @ResponseBody
    public List<DTO> getCategoriesById(@RequestParam Integer categoryId) {
        return categoryService.getCategoryByCategoryId(categoryId);
    }

    @GetMapping(value = "/northwind/categories", params = {"name"})
    @ResponseBody
    public List<DTO> getCategoriesByName(@RequestParam(required = false) String name) {
        return categoryService.getCategoriesByName(name);
    }


}
