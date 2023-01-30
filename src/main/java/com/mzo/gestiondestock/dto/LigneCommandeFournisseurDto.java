package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;

import com.mzo.gestiondestock.entities.LigneCommandeFournisseur;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
public class LigneCommandeFournisseurDto {
	private Integer id;
    private ArticleDto article;
	
 
	private CommandeFournisseurDto commandefournisseur;
	
    private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
    private Integer idEntreprise;
	
	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
		
		if(ligneCommandeFournisseur == null) {
			return null;
		}
		
		LigneCommandeFournisseurDto ligneCommandeFournisseurDto = new LigneCommandeFournisseurDto();
		
		ligneCommandeFournisseurDto.setId(ligneCommandeFournisseur.getId());
		ligneCommandeFournisseurDto.setQuantite(ligneCommandeFournisseur.getQuantite());
		ligneCommandeFournisseurDto.setPrixUnitaire(ligneCommandeFournisseur.getPrixUnitaire());
		ligneCommandeFournisseurDto.setArticle(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()));
		ligneCommandeFournisseurDto.setCommandefournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandefournisseur()));
		ligneCommandeFournisseurDto.setIdEntreprise(ligneCommandeFournisseur.getIdEntreprise());
		
		
		return ligneCommandeFournisseurDto;
		/*return LigneCommandeFournisseurDto.builder().id(ligneCommandeFournisseur.getId())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.commandefournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandefournisseur()))
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				.build();*/
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
		ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseurDto.getIdEntreprise());
		
		return ligneCommandeFournisseur;
		
	}

	public LigneCommandeFournisseurDto() {
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

	public CommandeFournisseurDto getCommandefournisseur() {
		return commandefournisseur;
	}

	public void setCommandefournisseur(CommandeFournisseurDto commandefournisseur) {
		this.commandefournisseur = commandefournisseur;
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
