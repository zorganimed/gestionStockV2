package com.mzo.gestiondestock.entities;

import java.time.Instant;
import java.util.List;

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
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends AbstractEntity{
	
	private String code;
	
	private Instant dateCommande;
	private Integer idEntreprise;
	
	@ManyToOne
	@JoinColumn(name = "idfournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy = "commandefournisseur")
	List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

	public CommandeFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeFournisseur(Integer id, Instant creationDate, Instant lastUpdateDate, String code,
			Instant dateCommande, Integer idEntreprise, Fournisseur fournisseur,
			List<LigneCommandeFournisseur> ligneCommandeFournisseurs) {
		super(id, creationDate, lastUpdateDate);
		this.code = code;
		this.dateCommande = dateCommande;
		this.idEntreprise = idEntreprise;
		this.fournisseur = fournisseur;
		this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Instant getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Instant dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneCommandeFournisseur> getLigneCommandeFournisseurs() {
		return ligneCommandeFournisseurs;
	}

	public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseur> ligneCommandeFournisseurs) {
		this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
	}
	
	
	

}
