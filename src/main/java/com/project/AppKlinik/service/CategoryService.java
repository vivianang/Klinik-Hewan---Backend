package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddCategoryRequestDto;
import com.project.AppKlinik.dto.UpdateCategoryRequestDto;
import com.project.AppKlinik.model.Category;
import com.project.AppKlinik.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category addCategory(AddCategoryRequestDto requestDto) {
        return categoryRepository.saveAndFlush(Category.builder()
                .description(requestDto.getDescription())
                .type(requestDto.getType())
                .build());
    }

    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid Category Id"));
    }

    public Category updateCategory(UpdateCategoryRequestDto requestDto) {
        Category categoryToUpdate = getCategoryById(requestDto.getId());
        categoryToUpdate.setDescription(requestDto.getDescription());
        categoryToUpdate.setType(requestDto.getType());
        return categoryRepository.saveAndFlush(categoryToUpdate);
    }

    public String deleteCategory(UUID id) {
        Category categoryToDelete = getCategoryById(id);
        categoryRepository.delete(categoryToDelete);
        return "Success delete Category";
    }
}
