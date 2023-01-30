package com.mzo.gestiondestock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mzo.gestiondestock.api.FournisseurApi;
import com.mzo.gestiondestock.dto.FournisseurDto;
import com.mzo.gestiondestock.services.FournisseurService;

@RestController
public class FournisseurController implements FournisseurApi{

	private FournisseurService fournisseurService;
	
	@Autowired
	public FournisseurController(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	@Override
	public FournisseurDto save(FournisseurDto dto) {
		// TODO Auto-generated method stub
		return fournisseurService.save(dto);
	}

	@Override
	public FournisseurDto findById(Integer id) {
		// TODO Auto-generated method stub
		return fournisseurService.findById(id);
	}

	@Override
	public List<FournisseurDto> findAll() {
		// TODO Auto-generated method stub
		return fournisseurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		fournisseurService.delete(id);
	}

}
