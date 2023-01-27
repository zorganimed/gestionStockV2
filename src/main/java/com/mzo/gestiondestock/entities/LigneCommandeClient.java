package com.mzo.gestiondestock.entities;

import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name = "lignecommandeclient")
public class LigneCommandeClient extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name = "idarticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "idcommandeclient")
	private CommandeClient commandeclient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	private Integer idEntreprise;

	public LigneCommandeClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommandeClient(Integer id, Instant creationDate, Instant lastUpdateDate, Article article,
			CommandeClient commandeclient, BigDecimal quantite, BigDecimal prixUnitaire, Integer idEntreprise) {
		super(id, creationDate, lastUpdateDate);
		this.article = article;
		this.commandeclient = commandeclient;
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

	public CommandeClient getCommandeclient() {
		return commandeclient;
	}

	public void setCommandeclient(CommandeClient commandeclient) {
		this.commandeclient = commandeclient;
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
