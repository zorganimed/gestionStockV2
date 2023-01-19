package com.mzo.gestiondestock.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	

}
