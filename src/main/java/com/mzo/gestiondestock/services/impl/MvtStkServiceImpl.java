package com.mzo.gestiondestock.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzo.gestiondestock.dto.MvtStkDto;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.MvtStkRepository;
import com.mzo.gestiondestock.services.MvtStkService;
import com.mzo.gestiondestock.validator.MvtStkDtoValidator;

@Service
public class MvtStkServiceImpl implements MvtStkService{
 
	private MvtStkRepository mvtStkRepository;
	
	@Autowired
	public MvtStkServiceImpl(MvtStkRepository mvtStkRepository) {
		this.mvtStkRepository = mvtStkRepository;
	}
	
	
	@Override
	public MvtStkDto save(MvtStkDto dto) {

		List<String> errors = MvtStkDtoValidator.validate(dto);

		if(!errors.isEmpty()) {
 		//	log.error("Category is not valid",dto);
 			throw new InvalidEntityException("Mvt n'est pas valide", ErrorCodes.MVT_STK_NOT_FOUND, errors);
		}
		return MvtStkDto.fromEntity(mvtStkRepository.save(MvtStkDto.toEntity(dto)));
	}

	@Override
	public MvtStkDto findById(Integer id) {
		if(id == null) {
			return null;
		}
		return mvtStkRepository.findById(id).map(MvtStkDto::fromEntity).orElseThrow(()->new EntityNotFoundException("Mvt not found", ErrorCodes.MVT_STK_NOT_FOUND));
	}

	@Override
	public List<MvtStkDto> findAll() {
		 
		return mvtStkRepository.findAll().stream().map(MvtStkDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			return;
		}
		mvtStkRepository.deleteById(id);
		
	}

}
