package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Fournisseur;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
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
		
		FournisseurDto fournisseurDto = new FournisseurDto();
		
		fournisseurDto.setId(fournisseur.getId());
		fournisseurDto.setNom(fournisseur.getNom());
		fournisseurDto.setPrenom(fournisseur.getPrenom());
		fournisseurDto.setPhoto(fournisseur.getPhoto());
		fournisseurDto.setMail(fournisseur.getMail());
		fournisseurDto.setNumTel(fournisseur.getNumTel());
		fournisseurDto.setAdresse(AdresseDto.fromEntity(fournisseur.getAdresse()));
		
		return fournisseurDto;
		
		/*return FournisseurDto.builder().id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.photo(fournisseur.getPhoto())
				.mail(fournisseur.getMail())
				.numTel(fournisseur.getNumTel())
				.adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
				.build();*/
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


	public FournisseurDto() {
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}


	public List<CommandeFournisseurDto> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}


	public void setCommandeFournisseurs(List<CommandeFournisseurDto> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}
	
	
	
}
