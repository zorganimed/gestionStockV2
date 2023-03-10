package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;

import com.mzo.gestiondestock.entities.LigneVente;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
public class LigneVenteDto {

	private Integer id;
    private VentesDto vente;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
    private Integer idEntreprise;
    
    private ArticleDto article;

	public static LigneVenteDto fromEntity(LigneVente ligneVente) {
		
		if(ligneVente == null) {
			return null;
		}
		
		LigneVenteDto ligneVenteDto = new LigneVenteDto();
		
		ligneVenteDto.setId(ligneVente.getId());
		ligneVenteDto.setQuantite(ligneVente.getQuantite());
		ligneVenteDto.setPrixUnitaire(ligneVente.getPrixUnitaire());
		ligneVenteDto.setVente(VentesDto.fromEntity(ligneVente.getVente()));
		ligneVenteDto.setIdEntreprise(ligneVente.getIdEntreprise());
		ligneVenteDto.setArticle(ArticleDto.fromEntity(ligneVente.getArticle()));
		
		return ligneVenteDto;
		
		/*return LigneVenteDto.builder().id(ligneVente.getId())
				.quantite(ligneVente.getQuantite())
				.prixUnitaire(ligneVente.getPrixUnitaire())
				.vente(VentesDto.fromEntity(ligneVente.getVente()))
				.build();*/
	}
	
	public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
		
		if(ligneVenteDto == null) {
			return null;
		}
		
		LigneVente ligneVente =new LigneVente();
		
		ligneVente.setId(ligneVenteDto.getId());
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
		ligneVente.setVente(VentesDto.toEntity(ligneVenteDto.getVente()));
		ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());
		ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
		
		return ligneVente;
	}

	public LigneVenteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VentesDto getVente() {
		return vente;
	}

	public void setVente(VentesDto vente) {
		this.vente = vente;
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
		
	public ArticleDto getArticle() {
		return article;
	}

	public void setArticle(ArticleDto article) {
		this.article = article;
	}
}
