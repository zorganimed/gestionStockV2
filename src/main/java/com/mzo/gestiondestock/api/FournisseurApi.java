package com.mzo.gestiondestock.api;

import static com.mzo.gestiondestock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mzo.gestiondestock.dto.FournisseurDto;

public interface FournisseurApi {
	
	@PostMapping(value = APP_ROOT+"/fournisseurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	FournisseurDto save(FournisseurDto dto);
	
	@GetMapping(value = APP_ROOT+"/fournisseurs/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
	FournisseurDto findById(@PathVariable("idFournisseur") Integer id);
	
	@GetMapping(value = APP_ROOT+"/fournisseurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<FournisseurDto> findAll();
	
	@DeleteMapping(value =  APP_ROOT+"/fournisseurs/delete/{idFournisseur}")
	void delete(@PathVariable("idFournisseur") Integer id);

}
