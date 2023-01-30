package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.FournisseurDto;

public interface FournisseurService {
	
	FournisseurDto save(FournisseurDto dto);
	FournisseurDto findById(Integer id);
	List<FournisseurDto> findAll();
	void delete(Integer id);

}
