package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.FournisseurDto;

public class FournisseurValidator {

public static List<String> validate(FournisseurDto dto){
		
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner le nom du fournisseur");
			errors.add("Veuillez renseigner le prenom du fournisseur");
			errors.add("Veuillez renseigner le mail du fournisseur");
			errors.add("Veuillez renseigner le numero de telephone du fournisseur");
			return errors;
			
		}
		
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Veuillez renseigner le nom du fournisseur");
		}
		
		if(!StringUtils.hasLength(dto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom du fournisseur");
		}
		
		if(!StringUtils.hasLength(dto.getMail())) {
			errors.add("Veuillez renseigner le mail du fournisseur");
		}
		
		if(!StringUtils.hasLength(dto.getNumTel())) {
			errors.add("Veuillez renseigner le numero de telephone du fournisseur");
		}
		
 		return errors;
		
	}
}
