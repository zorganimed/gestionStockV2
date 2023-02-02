package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.VentesDto;

public interface VenteService {
	
	VentesDto save(VentesDto dto);
	VentesDto findById(Integer id);
	VentesDto findByCode(String code);
	List<VentesDto> findAll();
	void delete(Integer id);

}
