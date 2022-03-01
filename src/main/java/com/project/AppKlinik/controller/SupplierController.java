package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddSupplierRequestDto;
import com.project.AppKlinik.dto.UpdateSupplierRequestDto;
import com.project.AppKlinik.model.Supplier;
import com.project.AppKlinik.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("supplier")
@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    private List<Supplier> getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    @PostMapping
    private Supplier addSupplier(@RequestBody @Valid AddSupplierRequestDto requestDto) {
        return supplierService.addSupplier(requestDto);
    }

    @PutMapping
    private Supplier updateSupplier(@RequestBody @Valid UpdateSupplierRequestDto requestDto) {
        return supplierService.updateSupplier(requestDto);
    }

    @DeleteMapping
    private String deleteSupplier(@RequestParam UUID id) {
        return supplierService.deleteSupplier(id);
    }
}
