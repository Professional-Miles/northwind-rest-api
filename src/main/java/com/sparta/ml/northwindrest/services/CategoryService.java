package com.sparta.ml.northwindrest.services;

import com.sparta.ml.northwindrest.dto.CategoryDTO;
import com.sparta.ml.northwindrest.dto.DTO;
import com.sparta.ml.northwindrest.entities.CategoryEntity;
import com.sparta.ml.northwindrest.errorhandling.ErrorControl;
import com.sparta.ml.northwindrest.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    public List<DTO> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(this::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    public List<DTO> getCategoryByCategoryId(Integer categoryId) {
        List<DTO> thisList =
                categoryRepository
                        .findAll()
                        .stream()
                        .filter(categoryEntity -> categoryEntity.getId().equals(categoryId))
                        .map(this::convertToCategoryDTO)
                        .collect(Collectors.toList());

        if (thisList.isEmpty()) {
            return ErrorControl.emptyList();
        }
        return thisList;
    }

    public List<DTO> getCategoriesByName(String name) {
        if (name != null) {
            return categoryRepository
                    .findAll()
                    .stream()
                    .filter(categoryEntity -> categoryEntity.getCategoryName().contains(name))
                    .map(this::convertToCategoryDTO)
                    .collect(Collectors.toList());
        }
        return getAllCategories();
    }

    private CategoryDTO convertToCategoryDTO(CategoryEntity categoryEntity) {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryEntity.getId());
        categoryDTO.setCategoryName(categoryEntity.getCategoryName());
        categoryDTO.setDescription(categoryEntity.getDescription());

        return categoryDTO;
    }

}
