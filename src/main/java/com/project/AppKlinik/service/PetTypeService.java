package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddPetTypeRequestDto;
import com.project.AppKlinik.dto.UpdatePetTypeRequestDto;
import com.project.AppKlinik.model.PetType;
import com.project.AppKlinik.repository.PetTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetTypeService {
    @Autowired
    private PetTypeRepository petTypeRepository;

    public List<PetType> getAllPetType() {
        return petTypeRepository.findAll();
    }

    public PetType addPetType(AddPetTypeRequestDto requestDto) {
        return petTypeRepository.saveAndFlush(PetType.builder()
                .petTypeName(requestDto.getPetTypeName())
                .build());
    }

    public PetType getPetTypeById(UUID id) {
        return petTypeRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid Pet Type ID"));
    }

    public PetType updatePetType(UpdatePetTypeRequestDto requestDto) {
        PetType petTypeToUpdate = getPetTypeById(requestDto.getId());
        petTypeToUpdate.setPetTypeName(requestDto.getPetTypeName());
        return petTypeRepository.saveAndFlush(petTypeToUpdate);
    }

    public String deletePetType(UUID id) {
        PetType petTypeToDelete = getPetTypeById(id);
        petTypeRepository.delete(petTypeToDelete);
        return "Success delete pet type";
    }
}
