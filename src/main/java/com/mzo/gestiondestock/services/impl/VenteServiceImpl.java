package com.mzo.gestiondestock.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mzo.gestiondestock.dto.LigneVenteDto;
import com.mzo.gestiondestock.dto.UtilisateurDto;
import com.mzo.gestiondestock.dto.VentesDto;
import com.mzo.gestiondestock.entities.Article;
import com.mzo.gestiondestock.entities.LigneVente;
import com.mzo.gestiondestock.entities.Ventes;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.ArticleRepository;
import com.mzo.gestiondestock.repository.LigneVenteRepository;
import com.mzo.gestiondestock.repository.VentesRepository;
import com.mzo.gestiondestock.services.VenteService;
import com.mzo.gestiondestock.validator.VenteValidator;

@Service
public class VenteServiceImpl implements VenteService{
	
	private VentesRepository ventesRepository;
	private ArticleRepository articleRepository;
	private LigneVenteRepository ligneVenteRepository;
	
	@Autowired
	public VenteServiceImpl(VentesRepository ventesRepository, ArticleRepository articleRepository,
			LigneVenteRepository ligneVenteRepository) {
 		this.ventesRepository = ventesRepository;
		this.articleRepository = articleRepository;
		this.ligneVenteRepository = ligneVenteRepository;
	}
	

	@Override
	public VentesDto save(VentesDto dto) {
		List<String> errors = VenteValidator.validate(dto);
		if(!errors.isEmpty()) {
			throw new InvalidEntityException("Ventes n'estpas valide", ErrorCodes.VENTE_NOT_VALID,errors);
		}
		
		List<String> articleErrors = new ArrayList<>();
		
		dto.getLigneVentes().forEach(ligneVenteDto -> {
		Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
		if(article.isEmpty()) {
			articleErrors.add("Aucun article avec l'id "+ligneVenteDto.getArticle().getId()+" n'a été dans la BDD");
		}
		});
		
		if(!articleErrors.isEmpty()) {
			throw new InvalidEntityException("un ou plusieurs articles n'ont pas été trouvés dans la BDD ", ErrorCodes.VENTE_NOT_VALID, articleErrors);
		}
		Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));
		
		dto.getLigneVentes().forEach(ligneVenteDto->{
			LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
			ligneVente.setVente(savedVentes);
			ligneVenteRepository.save(ligneVente);
			
		});
		return VentesDto.fromEntity(savedVentes);
	}

	@Override
	public VentesDto findById(Integer id) {
		if(id == null) {
			return null;
		}
		return ventesRepository.findById(id).map(VentesDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucun vente n'a été trouvé dans la BDD avec l'id"+id, ErrorCodes.VENTE_NOT_FOUND));
	}

	@Override
	public List<VentesDto> findAll() { 
		return ventesRepository.findAll().stream().map(VentesDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			return;
		}
		ventesRepository.deleteById(id);
		
	}


	@Override
	public VentesDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			return null;
		}
		return ventesRepository.findVentesByCode(code).map(VentesDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Aucun vente n'a été trouvé dans la BDD le code "+code,ErrorCodes.VENTE_NOT_FOUND));
	
	}

}
