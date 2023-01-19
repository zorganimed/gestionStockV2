package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import com.mzo.gestiondestock.dto.MvtStkDto;

public class MvtStkDtoValidator {
	
	public static List<String> validate(MvtStkDto dto){
		
		List<String> errors = new ArrayList<>();
		
		if(dto == null) {
			errors.add("Veuillez renseigner la quantie de la mouvement stock");
			errors.add("Veuillez renseigner la date de mouvement de la mouvement stock");
			errors.add("Veuillez renseigner l'article de la mouvement stock");
			errors.add("Veuillez renseigner le type de mouvement de la mouvement stock");
			
			return errors;
		}
		
		if(dto.getQuantite() == null) {
			errors.add("Veuillez renseigner la quantie de la mouvement stock");
		}
		
		if(dto.getDateMvt() == null) {
			errors.add("Veuillez renseigner la date de mouvement de la mouvement stock");
		}
		
		if(dto.getArticle() == null) {
			errors.add("Veuillez renseigner l'article de la mouvement stock");
		}
		
		if(dto.getTypeMvt() == null) {
			errors.add("Veuillez renseigner le type de mouvement de la mouvement stock");
		}
		
		return errors;
	}

}
