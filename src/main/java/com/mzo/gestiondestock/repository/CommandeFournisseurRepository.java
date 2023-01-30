package com.mzo.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.CommandeFournisseur;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
	
	Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

}
