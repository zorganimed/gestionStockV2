package com.mzo.gestiondestock.api;

import static com.mzo.gestiondestock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mzo.gestiondestock.dto.EntrepriseDto;

import io.swagger.annotations.Api;

@Api(APP_ROOT+"/entreprises")
public interface EntrepriseApi {
	
	@PostMapping(value = APP_ROOT+"/entreprises/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto save(EntrepriseDto dto);
	
	@GetMapping(value = APP_ROOT+"/entreprises/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
	EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
	
	@GetMapping(value = APP_ROOT+"/entreprises/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<EntrepriseDto> findAll();
	
	@DeleteMapping(value =  APP_ROOT+"/entreprises/delete/{idEntreprise}")
	void delete(@PathVariable("idEntreprise") Integer id);
}
