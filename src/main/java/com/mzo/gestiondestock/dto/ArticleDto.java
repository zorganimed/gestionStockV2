package com.mzo.gestiondestock.dto;

import java.math.BigDecimal;

import com.mzo.gestiondestock.entities.Article;

/*import lombok.Builder;
import lombok.Data;*/

/*@Builder
@Data*/
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
 		
 		ArticleDto articleDto =new ArticleDto();
 		
 		articleDto.setId(article.getId());
 		articleDto.setCodeArticle(article.getCodeArticle());
 		articleDto.setDesignation(article.getDesignation());
 		articleDto.setTauxTva(article.getTauxTva());
 		articleDto.setPrixUnitaireHt(article.getPrixUnitaireHt());
 		articleDto.setPrixUnitaireTtc(article.getPrixUnitaireTtc());
 		articleDto.setPhoto(article.getPhoto());
 		articleDto.setCategory(CategoryDto.fromEntity(article.getCategory()));
 		
 		return articleDto;
 		/*return ArticleDto.builder()
 				.id(article.getId())
 				.codeArticle(article.getCodeArticle())
 				.designation(article.getDesignation())
 				.tauxTva(article.getTauxTva())
 				.prixUnitaireHt(article.getPrixUnitaireHt())
 				.prixUnitaireTtc(article.getPrixUnitaireTtc())
 				.photo(article.getPhoto())
 				.category(CategoryDto.fromEntity(article.getCategory()))
 				.build();*/
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

	public ArticleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleDto(Integer id, String codeArticle, String designation, BigDecimal prixUnitaireHt, BigDecimal tauxTva,
			BigDecimal prixUnitaireTtc, String photo, CategoryDto category) {
		super();
		this.id = id;
		this.codeArticle = codeArticle;
		this.designation = designation;
		this.prixUnitaireHt = prixUnitaireHt;
		this.tauxTva = tauxTva;
		this.prixUnitaireTtc = prixUnitaireTtc;
		this.photo = photo;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getPrixUnitaireHt() {
		return prixUnitaireHt;
	}

	public void setPrixUnitaireHt(BigDecimal prixUnitaireHt) {
		this.prixUnitaireHt = prixUnitaireHt;
	}

	public BigDecimal getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(BigDecimal tauxTva) {
		this.tauxTva = tauxTva;
	}

	public BigDecimal getPrixUnitaireTtc() {
		return prixUnitaireTtc;
	}

	public void setPrixUnitaireTtc(BigDecimal prixUnitaireTtc) {
		this.prixUnitaireTtc = prixUnitaireTtc;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}
 	
 	
	

}
