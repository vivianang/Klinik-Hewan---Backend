package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddPetRequestDto;
import com.project.AppKlinik.dto.UpdatePetRequestDto;
import com.project.AppKlinik.model.Pet;
import com.project.AppKlinik.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("pet")
@RestController
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPet() {
        return petService.getAllPet();
    }

    @PostMapping
    public Pet addPet(@RequestBody @Valid AddPetRequestDto requestDto) {
        return petService.addPet(requestDto);
    }

    @PutMapping
    public Pet updatPet(@RequestBody @Valid UpdatePetRequestDto requestDto) {
        return petService.updatePet(requestDto);
    }

    @DeleteMapping
    public String deletePet(@RequestParam UUID id) {
        return petService.deletePet(id);
    }

}