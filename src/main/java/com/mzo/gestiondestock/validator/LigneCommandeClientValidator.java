package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;


import com.mzo.gestiondestock.dto.LigneCommandeClientDto;


public class LigneCommandeClientValidator {
	
	public static List<String> validate(LigneCommandeClientDto dto){
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner la quantité de la ligne de commande client");
			errors.add("Veuillez renseigner le prix unitaire de la ligne de commande client");
			errors.add("Veuillez renseigner l'article de la ligne de commande client");
			errors.add("Veuillez renseigner la commande client de la ligne de commande client");
			return errors;
		}
		
		if(dto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantité de la ligne de commande client");
		}
		
		if(dto.getPrixUnitaire() == null) {
			errors.add("Veuillez renseigner le prix unitaire de la ligne de commande client");
		}
		
		if(dto.getArticle() == null) {
			errors.add("Veuillez renseigner l'article de la ligne de commande client");
		}
		
		if(dto.getCommandeclient() == null) {
			errors.add("Veuillez renseigner la commande client de la ligne de commande client");
		}
		
		return errors;
		}

}
