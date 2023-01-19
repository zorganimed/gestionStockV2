package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
