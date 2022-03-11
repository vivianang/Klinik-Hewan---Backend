package com.project.AppKlinik.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddSupplierRequestDto {
    private String companyName;
    @NotNull
    private String contactPerson;
    private String phoneNumber;
}
