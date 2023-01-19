package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.EntrepriseDto;

public class EntrepriseValidator {
	
	public static List<String> validate(EntrepriseDto dto){
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner le nom de l'entreprise");
			errors.add("Veuillez renseigner le code fiscal de l'entreprise");
			errors.add("Veuillez renseigner l'email de l'entreprise");
			errors.add("Veuillez renseigner l'adresse de l'entreprise");
			
			return errors;
		}
		
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Veuillez renseigner le nom de l'entreprise");
		}
		
		if(!StringUtils.hasLength(dto.getEmail())) {
			errors.add("Veuillez renseigner l'email de l'entreprise");
		}
		
		if(!StringUtils.hasLength(dto.getCodeFiscal())) {
			errors.add("Veuillez renseigner le code fiscal de l'entreprise");
		}
		
		if(dto.getAdresse() == null) {
			errors.add("Veuillez renseigner l'adresse de l'entreprise");
		}else {
			if(!StringUtils.hasLength(dto.getAdresse().getAdresse1())) {
    			errors.add("Le champs adresse 1 est obligatoire");
    		}
        	
        	if(!StringUtils.hasLength(dto.getAdresse().getVille())) {
    			errors.add("Le champs ville est obligatoire");
    		}
        	
        	if(!StringUtils.hasLength(dto.getAdresse().getCodePostale())) {
    			errors.add("Le champs code postale est obligatoire");
    		}
        	
        	if(!StringUtils.hasLength(dto.getAdresse().getPays())) {
        		errors.add("Le champs pays est obligatoire");
			
		}
		
		
	}
		return errors;
		
	}
}
