package com.mzo.gestiondestock.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
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
}
