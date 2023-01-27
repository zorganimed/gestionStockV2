package com.mzo.gestiondestock.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "article")
public class Article extends AbstractEntity{
	
	private String codeArticle;
 	private String designation;
 	private BigDecimal prixUnitaireHt;
 	private BigDecimal tauxTva;
 	private BigDecimal prixUnitaireTtc;
 	private String photo;
 	private Integer idEntreprise;
 	
 	
 	@ManyToOne
 	@JoinColumn(name = "idcategory")
 	private Category category;


	 


	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

 
	public Article(Integer id, Instant creationDate, Instant lastUpdateDate, String codeArticle, String designation,
			BigDecimal prixUnitaireHt, BigDecimal tauxTva, BigDecimal prixUnitaireTtc, String photo,
			Integer idEntreprise, Category category) {
		super(id, creationDate, lastUpdateDate);
		this.codeArticle = codeArticle;
		this.designation = designation;
		this.prixUnitaireHt = prixUnitaireHt;
		this.tauxTva = tauxTva;
		this.prixUnitaireTtc = prixUnitaireTtc;
		this.photo = photo;
		this.idEntreprise = idEntreprise;
		this.category = category;
	}


	public String getCodeArticle() {
		return codeArticle;
	}


	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public BigDecimal getPrixUnitaireHt() {
		return prixUnitaireHt;
	}


	public void setPrixUnitaireHt(BigDecimal prixUnitaireHt) {
		this.prixUnitaireHt = prixUnitaireHt;
	}


	public BigDecimal getTauxTva() {
		return tauxTva;
	}


	public void setTauxTva(BigDecimal tauxTva) {
		this.tauxTva = tauxTva;
	}


	public BigDecimal getPrixUnitaireTtc() {
		return prixUnitaireTtc;
	}


	public void setPrixUnitaireTtc(BigDecimal prixUnitaireTtc) {
		this.prixUnitaireTtc = prixUnitaireTtc;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Integer getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
 	
 	
 	
 	

}
