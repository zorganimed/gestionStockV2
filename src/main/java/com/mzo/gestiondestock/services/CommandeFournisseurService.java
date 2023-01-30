package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto dto);
	
    CommandeFournisseurDto findById(Integer id);
	
    CommandeFournisseurDto findByCodeArticle(String code);
	
	List<CommandeFournisseurDto> findAll();
	
	void delete (Integer id);
}
