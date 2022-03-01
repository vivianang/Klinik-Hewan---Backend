package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddInventoryRequestDto;
import com.project.AppKlinik.dto.UpdateInventoryRequestDto;
import com.project.AppKlinik.model.Inventory;
import com.project.AppKlinik.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("inventory")
@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping
    public Inventory addInventory(@RequestBody @Valid AddInventoryRequestDto requestDto) {
        return inventoryService.addInventory(requestDto);
    }

    @PutMapping
    public Inventory updateInventory(@RequestBody @Valid UpdateInventoryRequestDto requestDto) {
        return inventoryService.updateInventory(requestDto);
    }

    @DeleteMapping
    public String deleteInventory(@RequestParam UUID id) {
        return inventoryService.deleteInventory(id);
    }

}
