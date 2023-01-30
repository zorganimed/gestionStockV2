package com.mzo.gestiondestock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.mzo.gestiondestock.dto.CommandeFournisseurDto;

import com.mzo.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.mzo.gestiondestock.entities.Article;


import com.mzo.gestiondestock.entities.CommandeFournisseur;
import com.mzo.gestiondestock.entities.Fournisseur;

import com.mzo.gestiondestock.entities.LigneCommandeFournisseur;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.ArticleRepository;
import com.mzo.gestiondestock.repository.CommandeFournisseurRepository;
import com.mzo.gestiondestock.repository.FournisseurRepository;

import com.mzo.gestiondestock.repository.LigneCommandeFournisseurRepository;
import com.mzo.gestiondestock.services.CommandeFournisseurService;
import com.mzo.gestiondestock.validator.CommandeFournisseurValidator;

@Service
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService{
	
	private CommandeFournisseurRepository commandeFournisseurRepository ;
	private FournisseurRepository fournisseurRepository;
	private ArticleRepository articleRepository;
	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
	
	@Autowired
	public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
			FournisseurRepository fournisseurRepository, ArticleRepository articleRepository,
			LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository) {
		this.commandeFournisseurRepository = commandeFournisseurRepository;
		this.fournisseurRepository = fournisseurRepository;
		this.articleRepository = articleRepository;
		this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
		
	}
	
	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
		List<String> errors = CommandeFournisseurValidator.validate(dto);
		
		if(!errors.isEmpty()) {
	 		//	log.error("Category is not valid",dto);
	 			throw new InvalidEntityException("Commande client n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
			}
		
		Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
		
		if(fournisseur.isEmpty()) {
			throw new EntityNotFoundException("Aucun fournisseur avec l'id"+dto.getFournisseur().getId()+" n'a été trouve dans la BDD", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
		}
		
		List<String> articleErrors = new ArrayList<>();
		
		if(dto.getLigneCommandeFournisseurs() != null) {
			dto.getLigneCommandeFournisseurs().forEach(ligFrnClt->{
				if(ligFrnClt.getArticle() != null) {
				Optional<Article> article = articleRepository.findById(ligFrnClt.getArticle().getId());
				if(article.isEmpty()) {
					articleErrors.add("Article avec l'id "+ligFrnClt.getArticle().getId()+" n'existe pas");
				}
				}else{
					articleErrors.add("Impossible d'enregistrer un commande avec un article null");
				}
			});
		}
		
		if(!articleErrors.isEmpty()) {
			throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
			
		}
		
		CommandeFournisseur savedCmdFrn = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
		
		if(dto.getLigneCommandeFournisseurs() != null) {
		dto.getLigneCommandeFournisseurs().forEach(ligFrnClt->{
			LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligFrnClt);
			ligneCommandeFournisseur.setCommandefournisseur(savedCmdFrn);
			ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
		});
		
		}
		return CommandeFournisseurDto.fromEntity(savedCmdFrn);
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		if(id == null) {
			return null;
		}
		
		 return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune commande avec l'id "+id, ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public CommandeFournisseurDto findByCodeArticle(String code) {
		if(!StringUtils.hasLength(code)) {
			return null;
		}
		return commandeFournisseurRepository.findCommandeFournisseurByCode(code).map(CommandeFournisseurDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune commande avec le code "+code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		
		return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			return ;
		}
		
		commandeFournisseurRepository.deleteById(id);	
		
	}}
