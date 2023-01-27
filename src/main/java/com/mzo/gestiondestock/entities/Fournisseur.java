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
@Table(name = "fournisseur")
public class Fournisseur extends AbstractEntity{
	
private String nom;
	
	private String prenom;
	
	@Embedded
	private Adresse adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	private Integer idEntreprise;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<CommandeFournisseur> commandeFournisseurs;

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(Integer id, Instant creationDate, Instant lastUpdateDate, String nom, String prenom,
			Adresse adresse, String photo, String mail, String numTel, Integer idEntreprise,
			List<CommandeFournisseur> commandeFournisseurs) {
		super(id, creationDate, lastUpdateDate);
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.photo = photo;
		this.mail = mail;
		this.numTel = numTel;
		this.idEntreprise = idEntreprise;
		this.commandeFournisseurs = commandeFournisseurs;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
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

	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public List<CommandeFournisseur> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}

	public void setCommandeFournisseurs(List<CommandeFournisseur> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}
	
	

}
