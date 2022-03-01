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
@Table(name = "TBL_INVENTORY_CATEGORY")
public class InventoryCategory {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;

    @OneToOne()
    @JoinColumn(name="category_id")
    private Category categories;
    private String type;
    private String subType;
    @Column(name = "is_type")
    private Boolean isType;
}