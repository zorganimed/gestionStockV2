package com.mzo.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzo.gestiondestock.entities.MvtStk;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {

}
