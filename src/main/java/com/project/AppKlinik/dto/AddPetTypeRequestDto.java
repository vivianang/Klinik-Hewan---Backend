package com.project.AppKlinik.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddPetTypeRequestDto {
    @NotNull
    private String petTypeName;
}
