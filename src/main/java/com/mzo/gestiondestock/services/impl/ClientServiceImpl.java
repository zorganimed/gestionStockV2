package com.mzo.gestiondestock.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzo.gestiondestock.dto.ClientDto;
import com.mzo.gestiondestock.exception.EntityNotFoundException;
import com.mzo.gestiondestock.exception.ErrorCodes;
import com.mzo.gestiondestock.exception.InvalidEntityException;
import com.mzo.gestiondestock.repository.ClientRepository;
import com.mzo.gestiondestock.services.ClientService;
import com.mzo.gestiondestock.validator.ClientValidator;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;
	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository){
		
		this.clientRepository = clientRepository;
	}
	
	@Override
	public ClientDto save(ClientDto dto) {
		List<String> errors = ClientValidator.validate(dto);

		if(!errors.isEmpty()) {
 		//	log.error("Category is not valid",dto);
 			throw new InvalidEntityException("Client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
		}
		return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
	}

	@Override
	public ClientDto findById(Integer id) {
		if(id == null) {
			//	log.error("Category id is null");
				return null;
			}
		
 		return clientRepository.findById(id).map(ClientDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Client not found", ErrorCodes.CLIENT_NOT_FOUND));
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
			return ;
		}
		
		clientRepository.deleteById(id);
		
	}

}
