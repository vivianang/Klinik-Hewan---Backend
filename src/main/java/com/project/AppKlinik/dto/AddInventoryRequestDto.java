package com.project.AppKlinik.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddInventoryRequestDto {
    @NotNull
    private UUID inventoryCategory;
    @NotNull
    private String inventoryName;
    @NotNull
    private String brand;
    @NotNull
    private Double salesPrice;
    @NotNull
    private UUID unit;
    // @NotNull
    // private Integer qtyStock;
}
