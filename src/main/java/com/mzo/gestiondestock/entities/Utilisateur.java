package com.mzo.gestiondestock.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity {	

	private String nom;
	
	private String prenom;
	
	private String email;
	
	private Instant dateNaissance;
	
	private String motDePasse;
	
	@Embedded
	private Adresse adresse;
	
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "identreprise")
	private Entreprise entreprise;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Roles> roles;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Integer id, Instant creationDate, Instant lastUpdateDate, String nom, String prenom,
			String email, Instant dateNaissance, String motDePasse, Adresse adresse, String photo,
			Entreprise entreprise, List<Roles> roles) {
		super(id, creationDate, lastUpdateDate);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		this.photo = photo;
		this.entreprise = entreprise;
		this.roles = roles;
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

	public Instant getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Instant dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	

}
