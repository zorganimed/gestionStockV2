package com.mzo.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.UtilisateurDto;

public class UtilisateurValidator {

	public static List<String> validate(UtilisateurDto utilisateurDto){
		List<String> errors = new ArrayList<>();
		
		if(utilisateurDto == null) {
			errors.add("Veuillez renseigner le nom de l'utilisateur");
			errors.add("Veuillez renseigner le prenom de l'utilisateur");
			errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
			errors.add("Veuillez renseigner l'email de l'utilisateur");
			errors.add("Veuillez renseigner l'adresse de l'utilisateur");
			return errors;
		}
		
		// Validateur pour les informations de l'utilisateur
		if(!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("Veuillez renseigner le nom de l'utilisateur");
		}
		if(!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("Veuillez renseigner le prenom de l'utilisateur");
		}
		if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())) {
			errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
		}
		if(!StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("Veuillez renseigner l'email de l'utilisateur");
		}
		
		if(utilisateurDto.getDateNaissance() == null) {
			errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
			
		}

		// Validateur pour l'adresse de l'utilisateur
        if(utilisateurDto.getAdresse() == null) {
        	errors.add("Veuillez renseigner l'adresse de l'utilisateur");
        }else {
        	if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
    			errors.add("Le champs adresse 1 est obligatoire");
    		}
        	
        	if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
    			errors.add("Le champs ville est obligatoire");
    		}
        	
        	if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
    			errors.add("Le champs code postale est obligatoire");
    		}
        	
        	if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
    			errors.add("Le champs pays est obligatoire");
    		}
        }
		
		return errors;
	}
}
