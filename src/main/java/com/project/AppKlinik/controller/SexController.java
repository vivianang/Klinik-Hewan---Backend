package com.project.AppKlinik.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.AppKlinik.dto.AddSexRequestDto;
import com.project.AppKlinik.dto.UpdateSexRequestDto;
import com.project.AppKlinik.model.Sex;
import com.project.AppKlinik.service.SexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("sex")
@RestController
public class SexController {
    @Autowired
    private SexService sexService;

    @GetMapping
    public List<Sex> getAllSex() {
        return sexService.getAllSex();
    }

    @PostMapping
    public Sex addSex(@RequestBody @Valid AddSexRequestDto requestDto) {
        return sexService.addSex(requestDto);
    }

    @PutMapping
    public Sex updateSex(@RequestBody @Valid UpdateSexRequestDto requestDto) {
        return sexService.updateSex(requestDto);
    }

    @DeleteMapping
    public String deleteSex(@RequestParam UUID id) {
        return sexService.deleteSex(id);
    }
}
