package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddSexRequestDto;
import com.project.AppKlinik.dto.UpdateSexRequestDto;
import com.project.AppKlinik.model.Sex;
import com.project.AppKlinik.repository.SexRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SexService {
    @Autowired
    private SexRepository sexRepository;

    public List<Sex> getAllSex() {
        return sexRepository.findAll();
    }

    public Sex addSex(AddSexRequestDto requestDto) {
        return sexRepository.saveAndFlush(Sex.builder()
                .sexName(requestDto.getSexName())
                .build());
    }

    public Sex getSexById(UUID id) {
        return sexRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid Sex ID"));
    }

    public Sex updateSex(UpdateSexRequestDto requestDto) {
        Sex sexToUpdate = getSexById(requestDto.getId());
        sexToUpdate.setSexName(requestDto.getSexName());
        return sexRepository.saveAndFlush(sexToUpdate);
    }

    public String deleteSex(UUID id) {
        Sex sexToDelete = getSexById(id);
        sexRepository.delete(sexToDelete);
        return "Success delete sex";
    }
}
