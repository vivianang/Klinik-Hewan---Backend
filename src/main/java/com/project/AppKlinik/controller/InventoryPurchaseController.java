package com.project.AppKlinik.controller;

import java.util.List;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddInventoryPurchaseRequestDto;
import com.project.AppKlinik.model.InventoryPurchase;
import com.project.AppKlinik.service.InventoryPurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("inventory-purchase")
@RestController
public class InventoryPurchaseController {
    @Autowired
    private InventoryPurchaseService inventoryPurchaseService;

    @GetMapping
    public List<InventoryPurchase> getAllInventoryPurchase() {
        return inventoryPurchaseService.getAllInventoryPurchase();
    }

    @PostMapping
    public InventoryPurchase addInventoryPurchase(@RequestBody @Valid AddInventoryPurchaseRequestDto requestDto) {
        return inventoryPurchaseService.addInventoryPurchase(requestDto);
    }
}
