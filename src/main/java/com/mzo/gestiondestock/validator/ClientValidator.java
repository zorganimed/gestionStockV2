package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.ClientDto;

public class ClientValidator {
	
	public static List<String> validate(ClientDto dto){
		
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner le nom du client");
			errors.add("Veuillez renseigner le prenom du client");
			errors.add("Veuillez renseigner le mail du client");
			errors.add("Veuillez renseigner le numero de telephone du client");
			return errors;
			
		}
		
		if(!StringUtils.hasLength(dto.getNom())) {
			errors.add("Veuillez renseigner le nom du client");
		}
		
		if(!StringUtils.hasLength(dto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom du client");
		}
		
		if(!StringUtils.hasLength(dto.getMail())) {
			errors.add("Veuillez renseigner le mail du client");
		}
		
		if(!StringUtils.hasLength(dto.getNumTel())) {
			errors.add("Veuillez renseigner le numero de telephone du client");
		}
		
 		return errors;
		
	}

}
