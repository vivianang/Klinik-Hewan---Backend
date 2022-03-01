package com.project.AppKlinik.model;

import javax.persistence.*;
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
@Table(name = "TBL_Supplier")
public class Supplier {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "phone_number")
    private String phoneNumber;
}