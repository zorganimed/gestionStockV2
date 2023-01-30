package com.mzo.gestiondestock.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzo.gestiondestock.dto.FournisseurDto;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.FournisseurRepository;
import com.mzo.gestiondestock.services.FournisseurService;
import com.mzo.gestiondestock.validator.FournisseurValidator;

@Service
public class FournisseurServiceImpl implements FournisseurService{
	
	private FournisseurRepository fournisseurRepository;
	
	@Autowired
	public FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
		this.fournisseurRepository = fournisseurRepository;
	}

	@Override
	public FournisseurDto save(FournisseurDto dto) {
		 List<String> errors = FournisseurValidator.validate(dto);
			
			if(!errors.isEmpty()) {
	 		//	log.error("Article is not valid",dto);
	 			throw new InvalidEntityException("Fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
			}
		return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(dto)));
	}

	@Override
	public FournisseurDto findById(Integer id) {
		if(id == null) {
			//	log.error("Category id is null");
				return null;
			}
		return fournisseurRepository.findById(id).map(FournisseurDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Fournisseur not found", ErrorCodes.FOURNISSEUR_NOT_FOUND));
	}

	@Override
	public List<FournisseurDto> findAll() {
 		return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			//	log.error("Category id is null");
				return;
			} 
		fournisseurRepository.deleteById(id);
	}

}
