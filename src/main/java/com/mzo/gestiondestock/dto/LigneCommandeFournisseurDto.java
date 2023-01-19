package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;

import com.mzo.gestiondestock.entities.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	private Integer id;
    private ArticleDto article;
	
 
	private CommandeFournisseurDto commandefournisseur;
	
    private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
		
		if(ligneCommandeFournisseur == null) {
			return null;
		}
		
		return LigneCommandeFournisseurDto.builder().id(ligneCommandeFournisseur.getId())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.commandefournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandefournisseur()))
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				.build();
	}
	
	public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
		
		if(ligneCommandeFournisseurDto == null) {
			return null;
		}
		
		LigneCommandeFournisseur ligneCommandeFournisseur =new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
		ligneCommandeFournisseur.setCommandefournisseur(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandefournisseur()));
		ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
		
		return ligneCommandeFournisseur;
		
	}
}
