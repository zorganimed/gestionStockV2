package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.ArticleDto;
import com.mzo.gestiondestock.entities.Article;

public interface ArticleService {
	
	ArticleDto save(ArticleDto dto);
	
	ArticleDto findById(Integer id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	void delete (Integer id);

}
