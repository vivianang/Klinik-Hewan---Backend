package com.project.AppKlinik.model;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
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
@Table(name = "TBL_INVENTORY_PURCHASE")
public class InventoryPurchase {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;

    @OneToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @Column(name = "purchase_date")
    private String purchaseDate;
    @Column(name = "purchase_price")
    private Double purchasePrice;
    @OneToOne()
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    @Column(name = "qty_purchase")
    private Integer qtyPurchase;
}