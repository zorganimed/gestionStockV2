package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Adresse;
import com.mzo.gestiondestock.entities.Client;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientDto {

	private Integer id;
	
    private String nom;
	
	private String prenom;
	
 	private AdresseDto adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	@JsonIgnore
 	private List<CommandeClientDto> commandeClients;
	
	public static ClientDto fromEntity(Client client) {
		
		if(client == null) {
			return null;
		}
		
 		
		return ClientDto.builder().id(client.getId())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.photo(client.getPhoto())
				.mail(client.getMail())
				.numTel(client.getNumTel())
				.adresse(AdresseDto.fromEntity(client.getAdresse()))
				.build();
	}
	
	public static Client toEntity(ClientDto clientDto) {
		
		if(clientDto == null) {
			return null;
		}
		
		Client client = new Client();
		
		client.setId(clientDto.getId());
		client.setNom(clientDto.getNom());
		client.setPrenom(clientDto.getPrenom());
		client.setPhoto(clientDto.getPhoto());
		client.setMail(clientDto.getMail());
		client.setNumTel(clientDto.getNumTel());
		client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
		
		 
		return client;
		
	}
}
