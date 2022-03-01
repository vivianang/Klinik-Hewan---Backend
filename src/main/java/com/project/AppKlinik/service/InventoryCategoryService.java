package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddInventoryCategoryRequestDto;
import com.project.AppKlinik.dto.UpdateInventoryCategoryRequestDto;
import com.project.AppKlinik.model.InventoryCategory;
import com.project.AppKlinik.repository.InventoryCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryCategoryService {
    @Autowired
    private InventoryCategoryRepository inventoryCategoryRepository;
    @Autowired
    private CategoryService categoryService;

    public List<InventoryCategory> getAllInventoryCategory() {
        return inventoryCategoryRepository.findAll();
    }

    public InventoryCategory addInventoryCategory(AddInventoryCategoryRequestDto requestDto) {
        return inventoryCategoryRepository.saveAndFlush(InventoryCategory.builder()
                .categories(categoryService.getCategoryById(requestDto.getCategories()))
                .type(requestDto.getType())
                .subType(requestDto.getSubType())
                .isType(requestDto.getIsType())
                .build());
    }

    public InventoryCategory getInventoryCategoryById(UUID id) {
        return inventoryCategoryRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Invalid Inventory Category id"));
    }

    public InventoryCategory updateInventoryCategory(UpdateInventoryCategoryRequestDto requestDto) {
        InventoryCategory inventoryCategoryToUpdate = getInventoryCategoryById(requestDto.getId());
        inventoryCategoryToUpdate.setType(requestDto.getType());
        inventoryCategoryToUpdate.setSubType(requestDto.getSubType());
        inventoryCategoryToUpdate.setIsType(requestDto.getIsType());
        inventoryCategoryToUpdate.setCategories(categoryService.getCategoryById(requestDto.getCategories()));
        return inventoryCategoryRepository.saveAndFlush(inventoryCategoryToUpdate);
    }

    public String deleteInventoryCategory(UUID id) {
        InventoryCategory inventoryCategoryToDelete = getInventoryCategoryById(id);
        inventoryCategoryRepository.delete(inventoryCategoryToDelete);
        return "Success delete Invetory Category";
    }
}
