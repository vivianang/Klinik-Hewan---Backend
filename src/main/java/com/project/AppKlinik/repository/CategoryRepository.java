package com.project.AppKlinik.repository;

import java.util.UUID;

import com.project.AppKlinik.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
