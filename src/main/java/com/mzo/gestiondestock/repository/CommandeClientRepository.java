package com.mzo.gestiondestock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
	
	Optional<CommandeClient> findCommandeClientByCode(String code);

}
