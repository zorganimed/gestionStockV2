package com.mzo.gestiondestock.api;

import static com.mzo.gestiondestock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mzo.gestiondestock.dto.CategoryDto;

public interface CategoryApi {
	
	@PostMapping(value = APP_ROOT+"/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	CategoryDto save(CategoryDto dto);
	
	@GetMapping(value = APP_ROOT+"/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	CategoryDto findById(@PathVariable("idCategory")Integer id);
	
	@GetMapping(value = APP_ROOT+"/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	CategoryDto findByDesignationCategory(@PathVariable("codeCategory") String designation);
	
	@GetMapping(value = APP_ROOT+"/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
	List<CategoryDto> findAll();
	
	@DeleteMapping(value =  APP_ROOT+"/categories/delete/{idCategory}")
	void delete(@PathVariable("idCategory") Integer id); 

}
