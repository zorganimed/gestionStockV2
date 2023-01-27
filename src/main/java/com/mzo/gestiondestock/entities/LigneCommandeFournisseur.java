package com.mzo.gestiondestock.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "idarticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "idcommandeFournisseur")
	private CommandeFournisseur commandefournisseur;
	
    private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private Integer idEntreprise;

	public LigneCommandeFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommandeFournisseur(Integer id, Instant creationDate, Instant lastUpdateDate, Article article,
			CommandeFournisseur commandefournisseur, BigDecimal quantite, BigDecimal prixUnitaire,
			Integer idEntreprise) {
		super(id, creationDate, lastUpdateDate);
		this.article = article;
		this.commandefournisseur = commandefournisseur;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.idEntreprise = idEntreprise;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public CommandeFournisseur getCommandefournisseur() {
		return commandefournisseur;
	}

	public void setCommandefournisseur(CommandeFournisseur commandefournisseur) {
		this.commandefournisseur = commandefournisseur;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	
	
}
