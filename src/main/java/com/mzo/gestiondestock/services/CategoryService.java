package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto save(CategoryDto dto);
	CategoryDto findById(Integer id);
	CategoryDto findByDesignationCategory(String designation);
	List<CategoryDto> findAll();
	void delete(Integer id); 

}
