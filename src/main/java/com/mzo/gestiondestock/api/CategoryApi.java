package com.mzo.gestiondestock.api;

import static com.mzo.gestiondestock.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mzo.gestiondestock.dto.CategoryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(APP_ROOT+"/categories")
public interface CategoryApi {
	
	@PostMapping(value = APP_ROOT+"/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Enregistrer une catégorie", notes = "Cette méthode permet d'enregistrer ou modifier une catégorie", response = CategoryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet catégorie créé ou modifié"),
			@ApiResponse(code = 400, message = "L'objet catégorie n'est pas valide")
	})
	CategoryDto save(@RequestBody CategoryDto dto);
	
	@GetMapping(value = APP_ROOT+"/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Chercher une catégorie", notes = "Cette méthode permet de chercher une catégorie par son id", response = CategoryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet catégorie a été trouvé dans la BDD"),
			@ApiResponse(code = 404, message = "Aucune catégorie a été trouvé dans la BDD avec l'id fournie")
	})
	CategoryDto findById(@PathVariable("idCategory")Integer id);
	
	@GetMapping(value = APP_ROOT+"/categories/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Chercher une catégorie", notes = "Cette méthode permet de chercher une catégorie par son code", response = CategoryDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet catégorie a été trouvé dans la BDD"),
			@ApiResponse(code = 404, message = "Aucun catégorie a été trouvé dans la BDD avec le code fournie")
	})
	CategoryDto findByDesignationCategory(@PathVariable("codeCategory") String designation);
	
	@GetMapping(value = APP_ROOT+"/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoi la liste des categories", notes = "Cette méthode permet de chercher et renvoyer la liste des categories qui existent dans la BDD", responseContainer = "List<ArticleDto>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La liste des categories / une liste vide")
	})
	List<CategoryDto> findAll();
	
	@DeleteMapping(value =  APP_ROOT+"/categories/delete/{idCategory}")
	@ApiOperation(value = "Supprimer une catégorie", notes = "Cette méthode permet de supprimer une catégorie par son id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La catégorie a été supprimée")
	})
	void delete(@PathVariable("idCategory") Integer id); 

}
