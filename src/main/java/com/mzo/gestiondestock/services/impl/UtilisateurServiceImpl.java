package com.mzo.gestiondestock.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzo.gestiondestock.dto.UtilisateurDto;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.UtilisateurRepository;
import com.mzo.gestiondestock.services.UtilisateurService;
import com.mzo.gestiondestock.validator.UtilisateurValidator;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
	
		this.utilisateurRepository = utilisateurRepository;
	}
	
	@Override
	public UtilisateurDto save(UtilisateurDto dto) {
		 List<String> errors = UtilisateurValidator.validate(dto);
			
			if(!errors.isEmpty()) {
	 		//	log.error("Article is not valid",dto);
	 			throw new InvalidEntityException("Utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
			}
		return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
	}

	@Override
	public UtilisateurDto findById(Integer id) {
		if(id == null) {
			//	log.error("Category id is null");
				return null;
			}
		return utilisateurRepository.findById(id).map(UtilisateurDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Utilisateur not found", ErrorCodes.UTILISATEUR_NOT_FOUND) );
	}

	@Override
	public List<UtilisateurDto> findAll() {

		return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			//	log.error("Category id is null");
				return;
			} 
		
		utilisateurRepository.deleteById(id);
	}

}
