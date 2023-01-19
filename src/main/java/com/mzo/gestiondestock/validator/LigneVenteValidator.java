package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.mzo.gestiondestock.dto.LigneVenteDto;

public class LigneVenteValidator {

	public static List<String> validate(LigneVenteDto dto){
		
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner le prix unitaire de la ligne de vente");
			errors.add("Veuillez renseigner la quantite de la ligne de vente");
			errors.add("Veuillez renseigner le vente de la ligne de vente");
			
			return errors;
		}
		
		if(dto.getPrixUnitaire() == null) {
			errors.add("Veuillez renseigner le prix unitaire de la ligne de vente");
		}
		
		if(dto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantite de la ligne de vente");
		}
		
		if(dto.getVente() == null) {
			errors.add("Veuillez renseigner le vente de la ligne de vente");
		}
		
		
		
		
		
		return errors;
		
	}
}
