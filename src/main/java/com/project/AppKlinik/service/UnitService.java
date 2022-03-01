package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddUnitRequestDto;
import com.project.AppKlinik.dto.UpdateUnitRequestDto;
import com.project.AppKlinik.model.Unit;
import com.project.AppKlinik.repository.UnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnit() {
        return unitRepository.findAll();
    }

    public Unit addUnit(AddUnitRequestDto requestDto) {
        return unitRepository.saveAndFlush(Unit.builder()
                .description(requestDto.getDescription())
                .build());
    }

    public Unit getUnitById(UUID id) {
        return unitRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid unit id " + id));
    }

    public Unit updateUnit(UpdateUnitRequestDto requestDto) {
        Unit unitToUpdate = getUnitById(requestDto.getId());
        unitToUpdate.setDescription(requestDto.getDescription());
        return unitRepository.saveAndFlush(unitToUpdate);
    }

    public String deleteUnit(UUID id) {
        Unit unitToDelete = getUnitById(id);
        unitRepository.delete(unitToDelete);
        return "Success delete unit";
    }
}
