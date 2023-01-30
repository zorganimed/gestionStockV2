package com.mzo.gestiondestock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mzo.gestiondestock.api.CategoryApi;
import com.mzo.gestiondestock.dto.CategoryDto;
import com.mzo.gestiondestock.services.CategoryService;

@RestController
public class CategoryController implements CategoryApi{
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService){
		this.categoryService = categoryService;
	}

	@Override
	public CategoryDto save(CategoryDto dto) {
		 
		return categoryService.save(dto);
	}

	@Override
	public CategoryDto findById(Integer id) {
		 
		return categoryService.findById(id);
	}

	@Override
	public CategoryDto findByDesignationCategory(String designation) {
		 
		return categoryService.findByDesignationCategory(designation);
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return categoryService.findAll();
	}

	@Override
	public void delete(Integer id) {
		categoryService.delete(id);
		
	}

}
