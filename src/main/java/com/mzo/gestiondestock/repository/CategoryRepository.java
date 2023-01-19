package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
