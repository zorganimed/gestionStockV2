package com.mzo.gestiondestock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mzo.gestiondestock.api.EntrepriseApi;
import com.mzo.gestiondestock.dto.EntrepriseDto;
import com.mzo.gestiondestock.services.EntrepriseService;

@RestController
public class EntrepriseController implements EntrepriseApi{
	
	private EntrepriseService entrepriseService;
	
	@Autowired
	public EntrepriseController(EntrepriseService entrepriseService) {
		this.entrepriseService = entrepriseService;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
		// TODO Auto-generated method stub
		return entrepriseService.save(dto);
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		// TODO Auto-generated method stub
		return entrepriseService.findById(id);
	}

	@Override
	public List<EntrepriseDto> findAll() {
		// TODO Auto-generated method stub
		return entrepriseService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		entrepriseService.delete(id);
	}

}
