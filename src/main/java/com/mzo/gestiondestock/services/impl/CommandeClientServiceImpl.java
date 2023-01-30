package com.mzo.gestiondestock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.CommandeClientDto;
import com.mzo.gestiondestock.dto.LigneCommandeClientDto;
import com.mzo.gestiondestock.entities.Article;
import com.mzo.gestiondestock.entities.Client;
import com.mzo.gestiondestock.entities.CommandeClient;
import com.mzo.gestiondestock.entities.LigneCommandeClient;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.ArticleRepository;
import com.mzo.gestiondestock.repository.ClientRepository;
import com.mzo.gestiondestock.repository.CommandeClientRepository;
import com.mzo.gestiondestock.repository.LigneCommandeClientRepository;
import com.mzo.gestiondestock.services.CommandeClientService;
import com.mzo.gestiondestock.validator.CommandeClientValidator;

@Service
public class CommandeClientServiceImpl implements CommandeClientService{

	private CommandeClientRepository commandeClientRepository;
	private ClientRepository clientRepository;
	private ArticleRepository articleRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	
	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
			ClientRepository clientRepository, ArticleRepository articleRepository,
			LigneCommandeClientRepository ligneCommandeClientRepository) {
		this.commandeClientRepository = commandeClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository = articleRepository;
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
		
	}
	
	@Override
	public CommandeClientDto save(CommandeClientDto dto) {
		List<String> errors = CommandeClientValidator.validate(dto);
		
		if(!errors.isEmpty()) {
	 		//	log.error("Category is not valid",dto);
	 			throw new InvalidEntityException("Commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
			}
		
		Optional<Client> client = clientRepository.findById(dto.getClient().getId());
		
		if(client.isEmpty()) {
			throw new EntityNotFoundException("Aucun client avec l'id"+dto.getClient().getId()+" n'a été trouve dans la BDD", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
		}
		
		List<String> articleErrors = new ArrayList<>();
		
		if(dto.getLigneCommandeClients() != null) {
			dto.getLigneCommandeClients().forEach(ligCmdClt->{
				if(ligCmdClt.getArticle() != null) {
				Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
				if(article.isEmpty()) {
					articleErrors.add("Article avec l'id "+ligCmdClt.getArticle().getId()+" n'existe pas");
				}
				}else{
					articleErrors.add("Impossible d'enregistrer un commande avec un article null");
				}
			});
		}
		
		if(!articleErrors.isEmpty()) {
			throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
			
		}
		
		CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
		
		if(dto.getLigneCommandeClients() != null) {
		dto.getLigneCommandeClients().forEach(ligCmdClt->{
			LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
			ligneCommandeClient.setCommandeclient(savedCmdClt);
			ligneCommandeClientRepository.save(ligneCommandeClient);
		});
		
		}
		return CommandeClientDto.fromEntity(savedCmdClt);
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if(id == null) {
			return null;
		}
		
		 return commandeClientRepository.findById(id).map(CommandeClientDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune commande avec l'id "+id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public CommandeClientDto findByCodeArticle(String code) {
		if(!StringUtils.hasLength(code)) {
			return null;
		}
		return commandeClientRepository.findCommandeClientByCode(code).map(CommandeClientDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucune commande avec le code "+code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
	}

	@Override
	public List<CommandeClientDto> findAll() {
		return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			return ;
		}
		
		commandeClientRepository.deleteById(id);	
		
	}

}
