package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.UtilisateurDto;

public interface UtilisateurService {
	
	UtilisateurDto save(UtilisateurDto dto);
	UtilisateurDto findById(Integer id);
	List<UtilisateurDto> findAll();
	void delete(Integer id);

}
