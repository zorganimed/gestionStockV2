package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.mzo.gestiondestock.dto.LigneCommandeFournisseurDto;

public class LigneCommandeFournisseurValidator {

	public static List<String> validate(LigneCommandeFournisseurDto dto){
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner la quantité de la ligne de commande fournisseur");
			errors.add("Veuillez renseigner le prix unitaire de la ligne de commande fournisseur");
			errors.add("Veuillez renseigner l'article de la ligne de commande fournisseur");
			errors.add("Veuillez renseigner la commande client de la ligne de commande fournisseur");
			return errors;
		}
		
		if(dto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantité de la ligne de commande fournisseur");
		}
		
		if(dto.getPrixUnitaire() == null) {
			errors.add("Veuillez renseigner le prix unitaire de la ligne de commande fournisseur");
		}
		
		if(dto.getArticle() == null) {
			errors.add("Veuillez renseigner l'article de la ligne de commande fournisseur");
		}
		
		if(dto.getCommandefournisseur() == null) {
			errors.add("Veuillez renseigner la commande fournisseur de la ligne de commande fournisseur");
		}
		
		return errors;
		}
}
