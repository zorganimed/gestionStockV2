package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

}
