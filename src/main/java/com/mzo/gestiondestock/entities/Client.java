package com.mzo.gestiondestock.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;*/

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)*/
@Entity
@Table(name = "client")
public class Client extends AbstractEntity{
	
	private String nom;
	
	private String prenom;
	
	@Embedded
	private Adresse adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	private Integer idEntreprise;
	
	@OneToMany(mappedBy = "client")
	private List<CommandeClient> commandeClients;
	
	

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Integer id, Instant creationDate, Instant lastUpdateDate, String nom, String prenom, Adresse adresse,
			String photo, String mail, String numTel, Integer idEntreprise, List<CommandeClient> commandeClients) {
		super(id, creationDate, lastUpdateDate);
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.photo = photo;
		this.mail = mail;
		this.numTel = numTel;
		this.idEntreprise = idEntreprise;
		this.commandeClients = commandeClients;
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

	public List<CommandeClient> getCommandeClients() {
		return commandeClients;
	}

	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}
	
	

}
