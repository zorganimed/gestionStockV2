package com.mzo.gestiondestock.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzo.gestiondestock.dto.EntrepriseDto;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.EntrepriseRepository;
import com.mzo.gestiondestock.services.EntrepriseService;
import com.mzo.gestiondestock.validator.EntrepriseValidator;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
		this.entrepriseRepository = entrepriseRepository;
	}
	

	@Override
	public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
		
		if(!errors.isEmpty()) {
 		//	log.error("Article is not valid",dto);
 			throw new InvalidEntityException("Entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
		}
		return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
	}

	@Override
	public EntrepriseDto findById(Integer id) {
		if(id == null) {
			//	log.error("Category id is null");
				return null;
			}
		return entrepriseRepository.findById(id).map(EntrepriseDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Entreprise not found", ErrorCodes.ENTREPRISE_NOT_FOUND));
	}

	@Override
	public List<EntrepriseDto> findAll() {
		// TODO Auto-generated method stub
		return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			return ;
		}
		
		entrepriseRepository.deleteById(id);
		
	}
	
	

}
