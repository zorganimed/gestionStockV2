package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Entreprise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {
	
	private Integer id;
    private String nom;
	
	private String description;

	private AdresseDto adresse;
	
	private String codeFiscal;
	
	private String photo;
	
	private String email;
	
	private String siteWeb;
	
	@JsonIgnore
 	private List<UtilisateurDto> utilisateurs;
	
	public static EntrepriseDto fromEntity(Entreprise entreprise) {
		
		if(entreprise == null) {
			return null;
		}
		return EntrepriseDto.builder().id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
 				.codeFiscal(entreprise.getCodeFiscal())
 				.photo(entreprise.getPhoto())
 				.email(entreprise.getEmail())
 				.siteWeb(entreprise.getSiteWeb())
 				.adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
 				.build();
	}
	
	public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
		
		if(entrepriseDto == null) {
			return null;
		}
		
		Entreprise entreprise = new Entreprise();
		
		entreprise.setId(entrepriseDto.getId());
		entreprise.setNom(entrepriseDto.getNom());
		entreprise.setDescription(entrepriseDto.getDescription());
		entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
		entreprise.setPhoto(entrepriseDto.getPhoto());
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
		entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
		
		return entreprise;
		
	}

}
