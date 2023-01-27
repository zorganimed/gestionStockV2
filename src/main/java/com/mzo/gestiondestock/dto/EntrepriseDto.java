package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Entreprise;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
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
		
		EntrepriseDto entrepriseDto = new EntrepriseDto();
		
		entrepriseDto.setId(entreprise.getId());
		entrepriseDto.setNom(entreprise.getNom());
		entrepriseDto.setDescription(entreprise.getDescription());
		entrepriseDto.setCodeFiscal(entreprise.getCodeFiscal());
		entrepriseDto.setPhoto(entreprise.getPhoto());
		entrepriseDto.setEmail(entreprise.getEmail());
		entrepriseDto.setSiteWeb(entreprise.getSiteWeb());
		entrepriseDto.setAdresse(AdresseDto.fromEntity(entreprise.getAdresse()));
		
		return entrepriseDto;
		
		/*return EntrepriseDto.builder().id(entreprise.getId())
				.nom(entreprise.getNom())
				.description(entreprise.getDescription())
 				.codeFiscal(entreprise.getCodeFiscal())
 				.photo(entreprise.getPhoto())
 				.email(entreprise.getEmail())
 				.siteWeb(entreprise.getSiteWeb())
 				.adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
 				.build();*/
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

	public EntrepriseDto() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AdresseDto getAdresse() {
		return adresse;
	}

	public void setAdresse(AdresseDto adresse) {
		this.adresse = adresse;
	}

	public String getCodeFiscal() {
		return codeFiscal;
	}

	public void setCodeFiscal(String codeFiscal) {
		this.codeFiscal = codeFiscal;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public List<UtilisateurDto> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<UtilisateurDto> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	

}
