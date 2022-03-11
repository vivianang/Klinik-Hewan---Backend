package com.project.AppKlinik.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddInventoryCategoryRequestDto {
    @NotNull
    private UUID categories;
    @NotNull
    private String type;
    private String subType;
    @NotNull
    private Boolean isType;
}
