package com.mzo.gestiondestock.entities;

import java.time.Instant;
import java.util.List;

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
@Table(name = "category")
public class Category extends AbstractEntity{
	
	private String code;
	private String designation;
	private Integer idEntreprise;
	
	
	@OneToMany(mappedBy = "category")
	private List<Article> articles;


	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

 


	public Category(Integer id, Instant creationDate, Instant lastUpdateDate, String code, String designation,
			Integer idEntreprise, List<Article> articles) {
		super(id, creationDate, lastUpdateDate);
		this.code = code;
		this.designation = designation;
		this.idEntreprise = idEntreprise;
		this.articles = articles;
	}




	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Integer getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	public List<Article> getArticles() {
		return articles;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	

}
