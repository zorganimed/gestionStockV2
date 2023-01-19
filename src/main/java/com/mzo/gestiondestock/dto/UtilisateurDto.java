package com.mzo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Adresse;
import com.mzo.gestiondestock.entities.Entreprise;
import com.mzo.gestiondestock.entities.Utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {

	private Integer id;
    private String nom;
	
	private String prenom;
	
	private String email;
	
	private String motDePasse;
	
	private Instant dateNaissance;
	
	
 	private AdresseDto adresse;
	
	private String photo;
	
 
	private EntrepriseDto entreprise;
	
	//@JsonIgnore
 	private List<RolesDto> roles;
	
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
		if(utilisateur == null) {
			return null;
		}
		
		return UtilisateurDto.builder().id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.email(utilisateur.getEmail())
				.motDePasse(utilisateur.getMotDePasse())
				.dateNaissance(utilisateur.getDateNaissance())
				.adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
				.entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
				.photo(utilisateur.getPhoto())
				.build();
 	}
	public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
		
		if(utilisateurDto == null) {
			return null;
		}
		
		Utilisateur utilisateur =new Utilisateur();
		
		utilisateur.setId(utilisateurDto.getId());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
		utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
		utilisateur.setPhoto(utilisateurDto.getPhoto());
		utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
		utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
		
		return utilisateur;
	}
}
