package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddInventoryRequestDto;
import com.project.AppKlinik.dto.UpdateInventoryRequestDto;
import com.project.AppKlinik.model.Inventory;
import com.project.AppKlinik.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private UnitService unitService;
    @Autowired
    private InventoryCategoryService inventoryCategoryService;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory addInventory(AddInventoryRequestDto requestDto) {
        return inventoryRepository.saveAndFlush(Inventory.builder()
                .inventoryCategory(inventoryCategoryService.getInventoryCategoryById(requestDto.getInventoryCategory()))
                .inventoryName(requestDto.getInventoryName())
                .brand(requestDto.getBrand())
                .salesPrice(requestDto.getSalesPrice())
                .unit(unitService.getUnitById(requestDto.getUnit()))
                .qtyStock(0)
                .isDel(false)
                .build());
    }

    public Inventory getInventoryById(UUID id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid inventory id"));
    }

    public Inventory updateInventory(UpdateInventoryRequestDto requestDto) {
        Inventory inventoryToUpdate = getInventoryById(requestDto.getId());
        inventoryToUpdate.setInventoryCategory(
                inventoryCategoryService.getInventoryCategoryById(requestDto.getInventoryCategory()));
        inventoryToUpdate.setInventoryName(requestDto.getInventoryName());
        inventoryToUpdate.setBrand(requestDto.getBrand());
        inventoryToUpdate.setSalesPrice(requestDto.getSalesPrice());
        inventoryToUpdate.setUnit(unitService.getUnitById(requestDto.getUnit()));
        return inventoryRepository.saveAndFlush(inventoryToUpdate);
    }

    public String deleteInventory(UUID id) {
        Inventory inventoryToUpdate = getInventoryById(id);
        inventoryToUpdate.setIsDel(true);
        inventoryRepository.saveAndFlush(inventoryToUpdate);
        return "Success delete inventory";
    }
}
