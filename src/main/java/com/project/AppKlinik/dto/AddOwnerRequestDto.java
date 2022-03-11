package com.project.AppKlinik.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddOwnerRequestDto {
    @NotNull
    private String firstName;
    private String lastName;
    private String email;
    private String homePhone;
    private String businessPhone;
    private String address;
    private String fax;
    @NotNull
    private String mobilePhone;
    private String zipPostalCode;
    private String notes;
}
