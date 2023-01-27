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

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
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
		
		UtilisateurDto utilisateurDto = new UtilisateurDto();
		
		utilisateurDto.setId(utilisateur.getId());
		utilisateurDto.setNom(utilisateur.getNom());
		utilisateurDto.setPrenom(utilisateur.getPrenom());
		utilisateurDto.setEmail(utilisateur.getEmail());
		utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
		utilisateurDto.setDateNaissance(utilisateur.getDateNaissance());
		utilisateurDto.setAdresse(AdresseDto.fromEntity(utilisateur.getAdresse()));
		utilisateurDto.setEntreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()));
		utilisateurDto.setPhoto(utilisateur.getPhoto());
		
		return utilisateurDto;
		
		/*return UtilisateurDto.builder().id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.email(utilisateur.getEmail())
				.motDePasse(utilisateur.getMotDePasse())
				.dateNaissance(utilisateur.getDateNaissance())
				.adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
				.entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
				.photo(utilisateur.getPhoto())
				.build();*/
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
	public UtilisateurDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Instant getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Instant dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public AdresseDto getAdresse() {
		return adresse;
	}
	public void setAdresse(AdresseDto adresse) {
		this.adresse = adresse;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public EntrepriseDto getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(EntrepriseDto entreprise) {
		this.entreprise = entreprise;
	}
	public List<RolesDto> getRoles() {
		return roles;
	}
	public void setRoles(List<RolesDto> roles) {
		this.roles = roles;
	}
	
	
}
