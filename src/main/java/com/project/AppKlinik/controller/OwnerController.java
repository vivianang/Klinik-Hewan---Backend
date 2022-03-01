package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddOwnerRequestDto;
import com.project.AppKlinik.dto.UpdateOwnerRequestDto;
import com.project.AppKlinik.model.Owner;
import com.project.AppKlinik.service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("owner")
@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> getAllOwner() {
        return ownerService.getAllOwner();
    }

    @PostMapping
    public Owner addOwner(@RequestBody @Valid AddOwnerRequestDto requestDto) {
        return ownerService.addOwner(requestDto);
    }

    @PutMapping
    public Owner updatOwner(@RequestBody @Valid UpdateOwnerRequestDto requestDto) {
        return ownerService.updateOwner(requestDto);
    }

    @DeleteMapping
    public String deleteOwner(@RequestParam UUID id) {
        return ownerService.deleteOwner(id);
    }

}
