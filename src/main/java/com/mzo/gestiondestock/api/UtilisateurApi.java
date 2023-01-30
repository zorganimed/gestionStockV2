package com.mzo.gestiondestock.api;

import static com.mzo.gestiondestock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mzo.gestiondestock.dto.UtilisateurDto;

public interface UtilisateurApi {

	@PostMapping(value = APP_ROOT+"/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDto save(UtilisateurDto dto);
	
	@GetMapping(value = APP_ROOT+"/utilisateurs/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
	UtilisateurDto findById(@PathVariable("idEntreprise") Integer id);
	
	@GetMapping(value = APP_ROOT+"/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<UtilisateurDto> findAll();
	
	@DeleteMapping(value =  APP_ROOT+"/utilisateurs/delete/{idUtilisateur}")
	void delete(@PathVariable("idEntreprise") Integer id);
}
