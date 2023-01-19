package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.VentesDto;

public class VenteValidator {
	
public static List<String> validate(VentesDto dto){
		
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner le nom de vente");
			errors.add("Veuillez renseigner le commentaire de vente");
			return errors;
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veuillez renseigner le code de vente");
		}
		
		if(!StringUtils.hasLength(dto.getCommentaire())) {
			errors.add("Veuillez renseigner le commentaire de vente");
		}
		
		if(dto.getDateVente() ==null) {
			errors.add("Veuillez renseigner la date de vente");
		}
		return errors;
	}

}
