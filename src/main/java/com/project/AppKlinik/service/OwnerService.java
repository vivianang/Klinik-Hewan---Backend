package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddOwnerRequestDto;
import com.project.AppKlinik.dto.UpdateOwnerRequestDto;
import com.project.AppKlinik.model.Owner;
import com.project.AppKlinik.repository.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    public Owner addOwner(AddOwnerRequestDto requestDto) {
        return ownerRepository.saveAndFlush(Owner.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .email(requestDto.getEmail())
                .homePhone(requestDto.getHomePhone())
                .businessPhone(requestDto.getBusinessPhone())
                .address(requestDto.getAddress())
                .fax(requestDto.getFax())
                .mobilePhone(requestDto.getMobilePhone())
                .zipPostalCode(requestDto.getZipPostalCode())
                .notes(requestDto.getNotes())
                .build());
    }

    public Owner getOwnerById(UUID id) {
        return ownerRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid Owner id"));
    }

    public Owner updateOwner(UpdateOwnerRequestDto requestDto) {
        Owner ownerToUpdate = getOwnerById(requestDto.getId());
        ownerToUpdate.setFirstName(requestDto.getFirstName());
        ownerToUpdate.setLastName(requestDto.getLastName());
        ownerToUpdate.setEmail(requestDto.getEmail());
        ownerToUpdate.setHomePhone(requestDto.getHomePhone());
        ownerToUpdate.setBusinessPhone(requestDto.getBusinessPhone());
        ownerToUpdate.setAddress(requestDto.getAddress());
        ownerToUpdate.setFax(requestDto.getFax());
        ownerToUpdate.setMobilePhone(requestDto.getMobilePhone());
        ownerToUpdate.setZipPostalCode(requestDto.getZipPostalCode());
        ownerToUpdate.setNotes(requestDto.getNotes());
        return ownerRepository.saveAndFlush(ownerToUpdate);
    }

    public String deleteOwner(UUID id) {
        Owner ownerToDelete = getOwnerById(id);
        ownerRepository.delete(ownerToDelete);
        return "Success Delete Owner";
    }
}
