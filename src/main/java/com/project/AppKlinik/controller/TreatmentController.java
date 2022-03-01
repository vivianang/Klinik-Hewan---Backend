package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddTreatmentRequestDto;
import com.project.AppKlinik.dto.UpdateTreatmentRequestDto;
import com.project.AppKlinik.model.Treatment;
import com.project.AppKlinik.service.TreatmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("treatment")
@RestController
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @GetMapping
    public List<Treatment> getAllTreatment() {
        return treatmentService.getAllTreatment();
    }

    @PostMapping
    public Treatment addTreatment(@RequestBody @Valid AddTreatmentRequestDto requestDto) {
        return treatmentService.addTreatment(requestDto);
    }

    @PutMapping
    public Treatment updateTreatment(@RequestBody @Valid UpdateTreatmentRequestDto requestDto) {
        return treatmentService.updateTreatment(requestDto);
    }

    @DeleteMapping
    public String deleteTreatment(@RequestParam UUID id) {
        return treatmentService.deleteTreatment(id);
    }
}
