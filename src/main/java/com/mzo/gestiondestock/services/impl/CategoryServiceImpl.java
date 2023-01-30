package com.mzo.gestiondestock.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.CategoryDto;
import com.mzo.gestiondestock.entities.Category;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.CategoryRepository;
import com.mzo.gestiondestock.services.CategoryService;
 import com.mzo.gestiondestock.validator.CategoryValidator;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public CategoryDto save(CategoryDto dto) {
		 List<String> errors = CategoryValidator.validate(dto);

			if(!errors.isEmpty()) {
	 		//	log.error("Category is not valid",dto);
	 			throw new InvalidEntityException("Category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
			}
	 return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
	}

	@Override
	public CategoryDto findById(Integer id) {
    
		if(id == null) {
			//	log.error("Category id is null");
				return null;
			}
		
		/*Optional<Category> category = categoryRepository.findById(id);
		return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() -> new EntityNotFoundException("Category not found", ErrorCodes.CATEGORY_NOT_FOUND));*/
		
		return categoryRepository.findById(id).map(CategoryDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Category not found", ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public CategoryDto findByDesignationCategory(String designation) {
		 if(!StringUtils.hasLength(designation)) {
			 return null;
		 }
		 
		/* Optional<Category> category = categoryRepository.findCategoryByDesignation(designation);
 		 return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() -> new EntityNotFoundException("Category not found",ErrorCodes.CATEGORY_NOT_FOUND ));*/
		 
		 return categoryRepository.findCategoryByDesignation(designation).map(CategoryDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Category not found",ErrorCodes.CATEGORY_NOT_FOUND));
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
		if(id == null) {
			return ;
		}
		categoryRepository.deleteById(id);
		
	}

}
