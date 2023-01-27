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
@Table(name = "mvtstk")
public class MvtStk extends AbstractEntity{
	
	
	private Instant dateMvt;
	
	private BigDecimal quantite;
	
	private Integer idEntreprise;
		
	@ManyToOne
	@JoinColumn(name = "idarticle")
	private Article article;
	
	private TypeMvtStk typeMvt;

	public MvtStk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MvtStk(Integer id, Instant creationDate, Instant lastUpdateDate, Instant dateMvt, BigDecimal quantite,
			Integer idEntreprise, Article article, TypeMvtStk typeMvt) {
		super(id, creationDate, lastUpdateDate);
		this.dateMvt = dateMvt;
		this.quantite = quantite;
		this.idEntreprise = idEntreprise;
		this.article = article;
		this.typeMvt = typeMvt;
	}

	public Instant getDateMvt() {
		return dateMvt;
	}

	public void setDateMvt(Instant dateMvt) {
		this.dateMvt = dateMvt;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
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

	public TypeMvtStk getTypeMvt() {
		return typeMvt;
	}

	public void setTypeMvt(TypeMvtStk typeMvt) {
		this.typeMvt = typeMvt;
	}
	
	

}
