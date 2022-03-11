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
@Table(name = "TBL_PET")
public class Pet {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private UUID id;

    @OneToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "microchip")
    private String microchip;

    @OneToOne()
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @Column(name = "pet_age")
    private Integer petAge;

    @Column(name ="date_of_birth")
    private String dateOfBirth;

    private String color;

    private Boolean status;

    @Column(name ="deceased_date")
    private String deceasedDate;

    private String race;

    @OneToOne()
    @JoinColumn(name = "sex_id")
    private Sex sex;
}