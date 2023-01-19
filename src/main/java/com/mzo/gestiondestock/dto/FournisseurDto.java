package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {

	private Integer id;
    private String nom;
	
	private String prenom;
	
 	private AdresseDto adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	
	@JsonIgnore
 	private List<CommandeFournisseurDto> commandeFournisseurs;
	
	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		
		if(fournisseur == null) {
			return null;
		}
		
		return FournisseurDto.builder().id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.photo(fournisseur.getPhoto())
				.mail(fournisseur.getMail())
				.numTel(fournisseur.getNumTel())
				.adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
				.build();
	}
	
	
	public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
		
		if(fournisseurDto == null) {
			return null;
		}
		
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setMail(fournisseurDto.getMail());
		fournisseur.setNumTel(fournisseurDto.getNumTel());
		fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
		
		return fournisseur;
	}
}
