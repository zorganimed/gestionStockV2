package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Category;

import lombok.Builder;
import lombok.Data;


 
@Builder
@Data
public class CategoryDto {

	private Integer id;
	private String code;
	private String designation;
	
	@JsonIgnore
 	private List<ArticleDto> articles;
 	
 	public static  CategoryDto fromEntity(Category category) {
 		
 		if(category == null) {
 			return null;
 		}
  		return CategoryDto.builder()
  				.id(category.getId())
  				.code(category.getCode())
  				.designation(category.getDesignation())
  				.build();
  		
 	}
 	
 	public static Category toEntity(CategoryDto categoryDto) {
 		
 		if(categoryDto == null) {
 			return null;
 			}
 		Category category = new Category();
 		
 		category.setId(categoryDto.getId());
 		category.setCode(categoryDto.getCode());
 		category.setDesignation(categoryDto.getDesignation());
 		
 		return category;
 		
 		
 		
 	}
}
