package com.project.AppKlinik.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddCategoryRequestDto {
    @NotNull
    private String description;
    @NotNull
    private Boolean type;

}
