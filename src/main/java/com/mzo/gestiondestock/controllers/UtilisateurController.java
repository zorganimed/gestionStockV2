package com.mzo.gestiondestock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mzo.gestiondestock.api.UtilisateurApi;
import com.mzo.gestiondestock.dto.UtilisateurDto;
import com.mzo.gestiondestock.services.UtilisateurService;

@RestController
public class UtilisateurController implements UtilisateurApi{

	private UtilisateurService utilisateurService;
	
	@Autowired
	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		// TODO Auto-generated method stub
		return utilisateurService.save(dto);
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		// TODO Auto-generated method stub
		return utilisateurService.findById(id);
	}

	@Override
	public List<UtilisateurDto> findAll() {
		// TODO Auto-generated method stub
		return utilisateurService.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		utilisateurService.delete(id);
		
	}
}
