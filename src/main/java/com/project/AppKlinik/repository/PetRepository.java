package com.project.AppKlinik.repository;

import java.util.UUID;

import com.project.AppKlinik.model.Pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {
}
