package com.mzo.gestiondestock.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mzo.gestiondestock.dto.ArticleDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import static com.mzo.gestiondestock.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/articles")
public interface ArticleApi {

	
	@PostMapping(value = APP_ROOT+"/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette méthode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet article créé ou modifié"),
			@ApiResponse(code = 400, message = "L'objet article n'est pas valide")
	})
	ArticleDto save(@RequestBody ArticleDto dto);
	
	@GetMapping(value = APP_ROOT+"/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Chercher un article", notes = "Cette méthode permet de chercher un article par son id", response = ArticleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet article a été trouvé dans la BDD"),
			@ApiResponse(code = 404, message = "Aucun article a été trouvé dans la BDD avec l'id fournie")
	})
	ArticleDto findById(@PathVariable("idArticle") Integer id);
	
	@GetMapping(value = APP_ROOT+"/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Chercher un article", notes = "Cette méthode permet de chercher un article par son code", response = ArticleDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'objet article a été trouvé dans la BDD"),
			@ApiResponse(code = 404, message = "Aucun article a été trouvé dans la BDD avec le code fournie")
	})
	ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);
	
	@GetMapping(value = APP_ROOT+"/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoi la liste des articles", notes = "Cette méthode permet de chercher et renvoyer la liste des articles qui existent dans la BDD", responseContainer = "List<ArticleDto>")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "La liste des articles / une liste vide")
	})
	List<ArticleDto> findAll();
	
	@DeleteMapping(value =  APP_ROOT+"/articles/delete/{idArticle}")
	@ApiOperation(value = "Supprimer un article", notes = "Cette méthode permet de supprimer un article par son id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "L'article a été supprimé")
	})
	void delete (@PathVariable("idArticle") Integer id);
	
}
