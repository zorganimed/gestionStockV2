package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.CommandeClientDto;

public interface CommandeClientService {
	CommandeClientDto save(CommandeClientDto dto);
	
	CommandeClientDto findById(Integer id);
	
	CommandeClientDto findByCodeArticle(String code);
	
	List<CommandeClientDto> findAll();
	
	void delete (Integer id);
}
