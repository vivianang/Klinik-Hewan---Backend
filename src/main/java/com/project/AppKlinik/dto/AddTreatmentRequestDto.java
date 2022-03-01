package com.project.AppKlinik.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddTreatmentRequestDto {
    @NotNull
    private String description;
}
