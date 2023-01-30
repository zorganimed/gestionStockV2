package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.CommandeFournisseurDto;

public class CommandeFournisseurValidator {

public static List<String> validate(CommandeFournisseurDto dto){
		
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner le code de la commande fournisseur");
			errors.add("Veuillez renseigner la date de la commande fournisseur");
		return errors;
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veuillez renseigner le code de la commande fournisseur");
		}
		
		
		if(dto.getDateCommande() == null) {
			errors.add("Veuillez renseigner la date de la commande fournisseur");
		}
		return errors;
		}
}
