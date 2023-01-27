package com.mzo.gestiondestock.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;*/

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)*/
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity {
	
	private String nom;
	
	private String description;
	
	@Embedded
	private Adresse adresse;
	
	private String codeFiscal;
	
	private String photo;
	
	private String email;
	
	private String siteWeb;
	
	@OneToMany(mappedBy = "entreprise")
	private List<Utilisateur> utilisateurs;

	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entreprise(Integer id, Instant creationDate, Instant lastUpdateDate, String nom, String description,
			Adresse adresse, String codeFiscal, String photo, String email, String siteWeb,
			List<Utilisateur> utilisateurs) {
		super(id, creationDate, lastUpdateDate);
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.codeFiscal = codeFiscal;
		this.photo = photo;
		this.email = email;
		this.siteWeb = siteWeb;
		this.utilisateurs = utilisateurs;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
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

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	

}
