package com.project.AppKlinik.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddSupplierRequestDto {
    @NotNull
    private String companyName;
    @NotNull
    private String contactPerson;
    @NotNull
    private String phoneNumber;
}
