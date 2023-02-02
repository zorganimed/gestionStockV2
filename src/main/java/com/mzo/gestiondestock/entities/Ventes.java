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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)*/
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity{
	
	private String code;
	
	private Instant dateVente;
	
	private String commentaire;
	
	private Integer idEntreprise;
	
	@OneToMany(mappedBy = "vente")
	private List<LigneVente> ligneVentes;
	
	

	public Ventes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ventes(Integer id, Instant creationDate, Instant lastUpdateDate, String code, Instant dateVente,
			String commentaire, Integer idEntreprise) {
		super(id, creationDate, lastUpdateDate);
		this.code = code;
		this.dateVente = dateVente;
		this.commentaire = commentaire;
		this.idEntreprise = idEntreprise;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public Instant getDateVente() {
		return dateVente;
	}



	public void setDateVente(Instant dateVente) {
		this.dateVente = dateVente;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public Integer getIdEntreprise() {
		return idEntreprise;
	}



	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}
	
	
	

}
