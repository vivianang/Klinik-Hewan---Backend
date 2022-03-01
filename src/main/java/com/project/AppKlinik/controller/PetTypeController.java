package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddPetTypeRequestDto;
import com.project.AppKlinik.dto.UpdatePetTypeRequestDto;
import com.project.AppKlinik.model.PetType;
import com.project.AppKlinik.service.PetTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("pet-type")
@RestController
public class PetTypeController {
    @Autowired
    private PetTypeService petTypeService;

    @GetMapping
    public List<PetType> getAllPetType() {
        return petTypeService.getAllPetType();
    }

    @PostMapping
    public PetType addPetType(@RequestBody @Valid AddPetTypeRequestDto requestDto) {
        return petTypeService.addPetType(requestDto);
    }

    @PutMapping
    public PetType updatePetType(@RequestBody @Valid UpdatePetTypeRequestDto requestDto) {
        return petTypeService.updatePetType(requestDto);
    }

    @DeleteMapping
    public String deletePetType(@RequestParam UUID id) {
        return petTypeService.deletePetType(id);
    }
}
