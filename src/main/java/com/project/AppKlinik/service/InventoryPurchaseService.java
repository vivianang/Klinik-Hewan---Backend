package com.project.AppKlinik.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.project.AppKlinik.dto.AddInventoryPurchaseRequestDto;
import com.project.AppKlinik.model.Inventory;
import com.project.AppKlinik.model.InventoryPurchase;
import com.project.AppKlinik.repository.InventoryPurchaseRepository;
import com.project.AppKlinik.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryPurchaseService {
    @Autowired
    private InventoryPurchaseRepository inventoryPurchaseRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private InventoryService inventoryService;

    public List<InventoryPurchase> getAllInventoryPurchase() {
        return inventoryPurchaseRepository.findAll();
    }

    public InventoryPurchase addInventoryPurchase(AddInventoryPurchaseRequestDto requestDto) {

        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");  
        // LocalDateTime now = LocalDateTime.now();  
        // System.out.println(dtf.format(now));  
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        Inventory inventoryToUpdate = inventoryService.getInventoryById(requestDto.getInventory());
        Integer currentQty = inventoryToUpdate.getQtyStock() + requestDto.getQtyPurchase();
        inventoryToUpdate.setQtyStock(currentQty);
        inventoryRepository.saveAndFlush(inventoryToUpdate);
        // System.out.println("fwnqlgnlq" + dtf.format(now));  
        return inventoryPurchaseRepository.saveAndFlush(InventoryPurchase.builder()
                .supplier(supplierService.getSupplierById(requestDto.getSupplier()))
                .purchaseDate(simpleDateFormat.format(new Date()))
                .purchasePrice(requestDto.getPurchasePrice())
                .inventory(inventoryService.getInventoryById(requestDto.getInventory()))
                .qtyPurchase(requestDto.getQtyPurchase())
                .build());
    }
}
