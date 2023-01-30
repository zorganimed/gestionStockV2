package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;

import com.mzo.gestiondestock.entities.LigneCommandeClient;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
public class LigneCommandeClientDto {

	private Integer id;
    private ArticleDto article;
	
 	private CommandeClientDto commandeclient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
    
	private Integer idEntreprise;
	
	
	public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
		if(ligneCommandeClient == null) {
			return null;
		}
		
		LigneCommandeClientDto ligneCommandeClientDto = new LigneCommandeClientDto();
		
		ligneCommandeClientDto.setId(ligneCommandeClient.getId());
		ligneCommandeClientDto.setQuantite(ligneCommandeClient.getQuantite());
		ligneCommandeClientDto.setPrixUnitaire(ligneCommandeClient.getPrixUnitaire());
		ligneCommandeClientDto.setArticle(ArticleDto.fromEntity(ligneCommandeClient.getArticle()));
		ligneCommandeClientDto.setCommandeclient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeclient()));
		ligneCommandeClientDto.setIdEntreprise(ligneCommandeClient.getIdEntreprise());
 		
		return ligneCommandeClientDto;
		
		/*return LigneCommandeClientDto.builder().id(commandeClient.getId())
				.quantite(commandeClient.getQuantite())
				.prixUnitaire(commandeClient.getPrixUnitaire())
				.commandeclient(CommandeClientDto.fromEntity(commandeClient.getCommandeclient()))
				.article(ArticleDto.fromEntity(commandeClient.getArticle()))
				.build();*/
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
		ligneCommandeClient.setIdEntreprise(ligneCommandeClientDto.getIdEntreprise());
		
		return ligneCommandeClient;
	}

	public LigneCommandeClientDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArticleDto getArticle() {
		return article;
	}

	public void setArticle(ArticleDto article) {
		this.article = article;
	}

	public CommandeClientDto getCommandeclient() {
		return commandeclient;
	}

	public void setCommandeclient(CommandeClientDto commandeclient) {
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
