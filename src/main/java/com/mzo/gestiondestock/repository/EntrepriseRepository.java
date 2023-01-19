package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
