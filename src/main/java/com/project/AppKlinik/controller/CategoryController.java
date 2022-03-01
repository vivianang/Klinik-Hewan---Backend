package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddCategoryRequestDto;
import com.project.AppKlinik.dto.UpdateCategoryRequestDto;
import com.project.AppKlinik.model.Category;
import com.project.AppKlinik.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PostMapping
    public Category addCategory(@RequestBody @Valid AddCategoryRequestDto requestDto) {
        return categoryService.addCategory(requestDto);
    }

    @PutMapping
    public Category updateCategory(@RequestBody @Valid UpdateCategoryRequestDto requestDto) {
        return categoryService.updateCategory(requestDto);
    }

    @DeleteMapping
    public String deleteCategory(@RequestParam UUID id) {
        return categoryService.deleteCategory(id);
    }
}
