package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddSupplierRequestDto;
import com.project.AppKlinik.dto.UpdateSupplierRequestDto;
import com.project.AppKlinik.model.Supplier;
import com.project.AppKlinik.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier addSupplier(AddSupplierRequestDto requestDto) {
        return supplierRepository.saveAndFlush(Supplier.builder()
                .companyName(requestDto.getCompanyName())
                .contactPerson(requestDto.getContactPerson())
                .phoneNumber(requestDto.getPhoneNumber())
                .build());
    }

    public Supplier getSupplierById(UUID id) {
        return supplierRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid supplier id: " + id));
    }

    public Supplier updateSupplier(UpdateSupplierRequestDto requestDto) {
        Supplier supplierToUpdate = getSupplierById(requestDto.getId());
        supplierToUpdate.setCompanyName(requestDto.getCompanyName());
        supplierToUpdate.setContactPerson(requestDto.getContactPerson());
        supplierToUpdate.setPhoneNumber(requestDto.getPhoneNumber());
        return supplierRepository.saveAndFlush(supplierToUpdate);
    }

    public String deleteSupplier(UUID id) {
        Supplier supplierToDelete = getSupplierById(id);
        supplierRepository.delete(supplierToDelete);
        return "Success delete Supplier";
    }
}
