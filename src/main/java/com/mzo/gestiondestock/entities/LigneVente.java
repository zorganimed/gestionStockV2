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
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name = "idvente")
	private Ventes vente;
	
	@ManyToOne
	@JoinColumn(name = "idarticle")
	private Article article;

	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private Integer idEntreprise;

	public LigneVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneVente(Integer id, Instant creationDate, Instant lastUpdateDate, Ventes vente, BigDecimal quantite,
			BigDecimal prixUnitaire, Integer idEntreprise) {
		super(id, creationDate, lastUpdateDate);
		this.vente = vente;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.idEntreprise = idEntreprise;
	}

	public Ventes getVente() {
		return vente;
	}

	public void setVente(Ventes vente) {
		this.vente = vente;
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
	
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
