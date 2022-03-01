package com.project.AppKlinik.service;

import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

import com.project.AppKlinik.dto.AddTreatmentRequestDto;
import com.project.AppKlinik.dto.UpdateTreatmentRequestDto;
import com.project.AppKlinik.model.Treatment;
import com.project.AppKlinik.repository.TreatmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Treatment> getAllTreatment() {
        return treatmentRepository.findAll();
    }

    public Treatment addTreatment(AddTreatmentRequestDto requestDto) {
        return treatmentRepository.saveAndFlush(Treatment.builder()
                .description(requestDto.getDescription())
                .build());
    }

    public Treatment getTreatmentById(UUID id) {
        return treatmentRepository.findById(id).orElseThrow(() -> new ValidationException("Invalid Treatment id"));
    }

    public Treatment updateTreatment(UpdateTreatmentRequestDto requestDto) {
        Treatment treatmentToUpdate = getTreatmentById(requestDto.getId());
        treatmentToUpdate.setDescription(requestDto.getDescription());
        return treatmentRepository.saveAndFlush(treatmentToUpdate);
    }

    public String deleteTreatment(UUID id) {
        Treatment treatmentToDelete = getTreatmentById(id);
        treatmentRepository.delete(treatmentToDelete);
        return "Success delete treatment";
    }
}
