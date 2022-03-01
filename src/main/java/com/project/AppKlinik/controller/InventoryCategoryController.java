package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddInventoryCategoryRequestDto;
import com.project.AppKlinik.dto.UpdateInventoryCategoryRequestDto;
import com.project.AppKlinik.model.InventoryCategory;
import com.project.AppKlinik.service.InventoryCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("inventory-category")
@RestController
public class InventoryCategoryController {
    @Autowired
    private InventoryCategoryService inventoryCategoryService;

    @GetMapping
    public List<InventoryCategory> getAllInventoryCategory() {
        return inventoryCategoryService.getAllInventoryCategory();
    }

    @PostMapping
    public InventoryCategory addInventoryCategory(@RequestBody @Valid AddInventoryCategoryRequestDto requestDto) {
        return inventoryCategoryService.addInventoryCategory(requestDto);

    }

    @PutMapping
    public InventoryCategory updateInventoryCategory(@RequestBody @Valid UpdateInventoryCategoryRequestDto requestDto) {
        return inventoryCategoryService.updateInventoryCategory(requestDto);
    }

    @DeleteMapping
    public String deleteInventoryCategory(@RequestParam UUID id) {
        return inventoryCategoryService.deleteInventoryCategory(id);
    }
}
