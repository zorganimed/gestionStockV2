package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.Ventes;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

}
