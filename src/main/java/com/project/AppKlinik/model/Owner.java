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
@Table(name = "TBL_OWNER")
public class Owner {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "business_phone")
    private String businessPhone;

    private String address;

    private String fax;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "zip_postal_code")
    private String zipPostalCode;
    
    private String notes;
}