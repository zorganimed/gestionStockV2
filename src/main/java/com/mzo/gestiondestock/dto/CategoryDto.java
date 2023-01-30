package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Category;

/*import lombok.Builder;
import lombok.Data;*/


 
/*@Builder
@Data*/
public class CategoryDto {

	private Integer id;
	private String code;
	private String designation;
	private Integer idEntreprise;
	
	@JsonIgnore
 	private List<ArticleDto> articles;
 	
 	public static  CategoryDto fromEntity(Category category) {
 		
 		if(category == null) {
 			return null;
 		}
 		
 		CategoryDto categoryDto = new CategoryDto();
 		
 		categoryDto.setId(category.getId());
 		categoryDto.setCode(category.getCode());
 		categoryDto.setDesignation(category.getDesignation());
 		categoryDto.setIdEntreprise(category.getIdEntreprise());
  		
 		return categoryDto;
  		/*return CategoryDto.builder()
  				.id(category.getId())
  				.code(category.getCode())
  				.designation(category.getDesignation())
  				.build();*/
  		
 	}
 	
 	public static Category toEntity(CategoryDto categoryDto) {
 		
 		if(categoryDto == null) {
 			return null;
 			}
 		Category category = new Category();
 		
 		category.setId(categoryDto.getId());
 		category.setCode(categoryDto.getCode());
 		category.setDesignation(categoryDto.getDesignation());
 		category.setIdEntreprise(categoryDto.getIdEntreprise());
 		
 		return category;
 		
 		
 		
 	}

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Integer id, String code, String designation) {
		super();
		this.id = id;
		this.code = code;
		this.designation = designation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<ArticleDto> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleDto> articles) {
		this.articles = articles;
	}
 	
	 
	
		public Integer getIdEntreprise() {
			return idEntreprise;
		}

		public void setIdEntreprise(Integer idEntreprise) {
			this.idEntreprise = idEntreprise;
		}
}
