package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;

import com.mzo.gestiondestock.entities.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {

	private Integer id;
    private ArticleDto article;
	
 	private CommandeClientDto commandeclient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	public static LigneCommandeClientDto fromEntity(LigneCommandeClient commandeClient) {
		if(commandeClient == null) {
			return null;
		}
		
		return LigneCommandeClientDto.builder().id(commandeClient.getId())
				.quantite(commandeClient.getQuantite())
				.prixUnitaire(commandeClient.getPrixUnitaire())
				.commandeclient(CommandeClientDto.fromEntity(commandeClient.getCommandeclient()))
				.article(ArticleDto.fromEntity(commandeClient.getArticle()))
				.build();
	}
	
	public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
		if(ligneCommandeClientDto == null) {
			return null;
		}
		
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
		
		ligneCommandeClient.setId(ligneCommandeClientDto.getId());
		ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
		ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
		ligneCommandeClient.setCommandeclient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeclient()));
		ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
		
		return ligneCommandeClient;
	}
	
}
