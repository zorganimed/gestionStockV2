package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.CommandeClient;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

}
