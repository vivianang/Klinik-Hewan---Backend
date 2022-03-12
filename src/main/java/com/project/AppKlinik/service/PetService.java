package com.project.AppKlinik.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddPetRequestDto;
import com.project.AppKlinik.dto.UpdatePetRequestDto;
import com.project.AppKlinik.model.Pet;
import com.project.AppKlinik.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private PetTypeService petTypeService;
    @Autowired
    private SexService sexService;

    public List<Pet> getAllPet(UUID ownerId) {
        List<Pet> filterPetByOwner = new ArrayList<>();
        for (int i = 0; i < petRepository.findAll().size(); i++) {
            if (ownerId.equals(petRepository.findAll().get(i).getOwner().getId())) {
                filterPetByOwner.add(petRepository.findAll().get(i));
            }
        }

        return filterPetByOwner;
    }

    public Pet addPet(AddPetRequestDto requestDto) {
        return petRepository.saveAndFlush(Pet.builder()
                .owner(ownerService.getOwnerById(requestDto.getOwner()))
                .petName(requestDto.getPetName())
                .microchip(requestDto.getMicrochip())
                .petType(petTypeService.getPetTypeById(requestDto.getPetType()))
                .petAge(requestDto.getPetAge())
                .dateOfBirth(requestDto.getDateOfBirth())
                .color(requestDto.getColor())
                .status(requestDto.getStatus())
                .deceasedDate(requestDto.getDeceasedDate())
                .race(requestDto.getRace())
                .sex(sexService.getSexById(requestDto.getSex()))
                .build());
    }

    public Pet getPetById(UUID id) {
        return petRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid Pet id"));
    }

    public Pet updatePet(UpdatePetRequestDto requestDto) {
        Pet petToUpdate = getPetById(requestDto.getId());
        petToUpdate.setOwner(ownerService.getOwnerById(requestDto.getOwner()));
        petToUpdate.setPetName(requestDto.getPetName());
        petToUpdate.setMicrochip(requestDto.getMicrochip());
        petToUpdate.setPetType(petTypeService.getPetTypeById(requestDto.getPetType()));
        petToUpdate.setPetAge(requestDto.getPetAge());
        petToUpdate.setDateOfBirth(requestDto.getDateOfBirth());
        petToUpdate.setColor(requestDto.getColor());
        petToUpdate.setStatus(requestDto.getStatus());
        petToUpdate.setDeceasedDate(requestDto.getDeceasedDate());
        petToUpdate.setRace(requestDto.getRace());
        petToUpdate.setSex(sexService.getSexById(requestDto.getSex()));
        return petRepository.saveAndFlush(petToUpdate);
    }

    public String deletePet(UUID id) {
        Pet petToDelete = getPetById(id);
        petRepository.delete(petToDelete);
        return "Success Delete Pet";
    }
}
