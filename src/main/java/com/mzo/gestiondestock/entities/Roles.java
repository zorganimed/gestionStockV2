package com.mzo.gestiondestock.entities;

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
@Table(name = "roles")
public class Roles extends AbstractEntity{
	
	private String roleName;
	private Integer idEntreprise;
	
	@ManyToOne
	@JoinColumn(name = "idutilisateur")
	private Utilisateur utilisateur;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(Integer id, Instant creationDate, Instant lastUpdateDate, String roleName, Integer idEntreprise,
			Utilisateur utilisateur) {
		super(id, creationDate, lastUpdateDate);
		this.roleName = roleName;
		this.idEntreprise = idEntreprise;
		this.utilisateur = utilisateur;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

}
