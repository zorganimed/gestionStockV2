package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.CommandeClientDto;


public class CommandeClientValidator {

public static List<String> validate(CommandeClientDto dto){
		
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner le code de la commande client");
			errors.add("Veuillez renseigner la date de la commande client");
		return errors;
		}
		
		if(!StringUtils.hasLength(dto.getCode())) {
			errors.add("Veuillez renseigner le code de la commande client");
		}
		
		if(dto.getCode() == null) {
			errors.add("Veuillez renseigner le client de la commande client");
		}
		
		
		if(dto.getDateCommande() == null) {
			errors.add("Veuillez renseigner la date de la commande client");
		}
		return errors;
		}
}
