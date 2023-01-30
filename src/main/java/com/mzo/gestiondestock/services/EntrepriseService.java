package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.EntrepriseDto;

public interface EntrepriseService {

	EntrepriseDto save(EntrepriseDto dto);
	EntrepriseDto findById(Integer id);
	List<EntrepriseDto> findAll();
	void delete(Integer id);
	
}
