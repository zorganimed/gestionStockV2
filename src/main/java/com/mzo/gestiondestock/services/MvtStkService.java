package com.mzo.gestiondestock.services;

import java.util.List;

import com.mzo.gestiondestock.dto.MvtStkDto;

public interface MvtStkService {
	MvtStkDto save(MvtStkDto dto);
	MvtStkDto findById(Integer id);
	List<MvtStkDto> findAll();
	void delete(Integer id);
	

}
