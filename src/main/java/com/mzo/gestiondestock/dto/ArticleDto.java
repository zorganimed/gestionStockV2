package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;

import com.mzo.gestiondestock.entities.Article;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArticleDto {
	
	private Integer id;
	private String codeArticle;
 	private String designation;
 	private BigDecimal prixUnitaireHt;
 	private BigDecimal tauxTva;
 	private BigDecimal prixUnitaireTtc;
 	private String photo;
 	private CategoryDto category;
 	
 	
 	public static ArticleDto fromEntity(Article article) {
 		
 		if(article == null) {
 			return null;
 		}
 		
  		
 		return ArticleDto.builder()
 				.id(article.getId())
 				.codeArticle(article.getCodeArticle())
 				.designation(article.getDesignation())
 				.tauxTva(article.getTauxTva())
 				.prixUnitaireHt(article.getPrixUnitaireHt())
 				.prixUnitaireTtc(article.getPrixUnitaireTtc())
 				.photo(article.getPhoto())
 				.category(CategoryDto.fromEntity(article.getCategory()))
 				.build();
 	}
 	
 	public static Article toEntity(ArticleDto articleDto) {
 		if(articleDto == null) {
 			return null;
 		}
 		
 		Article article = new Article();
 		
 		article.setId(articleDto.getId());
 		article.setCodeArticle(articleDto.getCodeArticle());
 		article.setDesignation(articleDto.getDesignation());
 		article.setTauxTva(articleDto.getTauxTva());
 		article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
 		article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
 		article.setPhoto(articleDto.getPhoto());
 		article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
 		
 		return article;
 		
 	}
	

}
