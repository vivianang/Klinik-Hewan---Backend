package com.project.AppKlinik.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddOwnerRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String homePhone;
    @NotNull
    private String businessPhone;
    @NotNull
    private String address;
    @NotNull
    private String fax;
    @NotNull
    private String mobilePhone;
    @NotNull
    private String zipPostalCode;
    @NotNull
    private String notes;
}
