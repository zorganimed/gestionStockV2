package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.LigneVente;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {

}
