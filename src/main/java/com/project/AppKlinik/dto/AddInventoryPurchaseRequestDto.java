package com.project.AppKlinik.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddInventoryPurchaseRequestDto {
    @NotNull
    private UUID supplier;
    @NotNull
    private Double purchasePrice;
    @NotNull
    private UUID inventory;
    @NotNull
    private Integer qtyPurchase;
}
