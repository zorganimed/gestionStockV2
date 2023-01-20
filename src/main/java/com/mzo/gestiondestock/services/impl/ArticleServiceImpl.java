package com.mzo.gestiondestock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzo.gestiondestock.dto.ArticleDto;
import com.mzo.gestiondestock.entities.Article;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.ArticleRepository;
import com.mzo.gestiondestock.services.ArticleService;
import com.mzo.gestiondestock.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService{
	
	
	private ArticleRepository articleRepository;

	@Autowired
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public ArticleDto save(ArticleDto dto) {
		
		List<String> errors = ArticleValidator.validate(dto);
		
		if(!errors.isEmpty()) {
 			log.error("Article is not valid",dto);
 			throw new InvalidEntityException("Article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}
		
 		return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
	}

	@Override
	public ArticleDto findById(Integer id) {
		if(id == null) {
			log.error("Article id is null");
		}
		
		Optional<Article> article = articleRepository.findById(id);
		ArticleDto dto = ArticleDto.fromEntity(article.get());
		
		return Optional.of(dto).orElseThrow(() -> new EntityNotFoundException("Article not found", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
