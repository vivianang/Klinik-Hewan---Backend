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
@Table(name = "TBL_CATEGORY")
public class Category {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;
    private String description;
    private boolean type;
}