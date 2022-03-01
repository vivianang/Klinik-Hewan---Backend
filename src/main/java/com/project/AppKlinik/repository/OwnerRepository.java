package com.project.AppKlinik.repository;

import java.util.UUID;

import com.project.AppKlinik.model.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {

}
