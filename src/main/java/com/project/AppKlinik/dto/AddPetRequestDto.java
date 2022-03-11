package com.project.AppKlinik.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddPetRequestDto {
    @NotNull
    private UUID owner;

    @NotNull
    private String petName;

    private String microchip;

    @NotNull
    private UUID petType;

    private Integer petAge;

    private String dateOfBirth;

    private String color;

    @NotNull
    private Boolean status;

    private String deceasedDate;

    private String race;

    @NotNull
    private UUID sex;
}
