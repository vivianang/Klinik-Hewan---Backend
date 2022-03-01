package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddUnitRequestDto;
import com.project.AppKlinik.dto.UpdateUnitRequestDto;
import com.project.AppKlinik.model.Unit;
import com.project.AppKlinik.service.UnitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("unit")
@RestController
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping
    public List<Unit> getAllUnit() {
        return unitService.getAllUnit();
    }

    @PostMapping
    public Unit addUnit(@RequestBody @Valid AddUnitRequestDto requestDto) {
        return unitService.addUnit(requestDto);
    }

    @PutMapping
    public Unit updateUnit(@RequestBody @Valid UpdateUnitRequestDto requestDto) {
        return unitService.updateUnit(requestDto);
    }

    @DeleteMapping
    public String deleteUnit(@RequestParam UUID id) {
        return unitService.deleteUnit(id);
    }
}
