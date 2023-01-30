package com.mzo.gestiondestock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mzo.gestiondestock.api.ClientApi;
import com.mzo.gestiondestock.dto.ClientDto;
import com.mzo.gestiondestock.services.ClientService;

@RestController
public class ClientController implements ClientApi{
	
	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService){
		this.clientService = clientService;
	}

	@Override
	public ClientDto save(ClientDto dto) {
		 
		return clientService.save(dto);
	}

	@Override
	public ClientDto findById(Integer id) {
		// TODO Auto-generated method stub
		return clientService.findById(id);
	}

	@Override
	public List<ClientDto> findAll() {
		// TODO Auto-generated method stub
		return clientService.findAll();
	}

	@Override
	public void delete(Integer id) {
		clientService.delete(id);
		
	}

}
