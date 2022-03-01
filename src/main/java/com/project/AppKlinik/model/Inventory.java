package com.project.AppKlinik.model;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_INVENTORY")
public class Inventory {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;
    @OneToOne()
    @JoinColumn(name = "inventory_category_id")
    private InventoryCategory inventoryCategory;
    @Column(name = "inventory_name")
    private String inventoryName;
    private String brand;
    @Column(name = "sales_price")
    private Double salesPrice;
    @OneToOne()
    @JoinColumn(name = "unit_id")
    private Unit unit;
    @Column(name = "qty_stock")
    private Integer qtyStock;
    @Column(name = "is_del")
    private Boolean isDel;
}