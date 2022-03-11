package com.project.AppKlinik.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdatePetRequestDto extends AddPetRequestDto {
    @NotNull
    private UUID id;
}
