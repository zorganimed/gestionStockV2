package com.mzo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.CommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {
	
	private Integer id;
	private String code;
	private Instant dateCommande;
	
 
	private ClientDto client;
	@JsonIgnore
 	private List<LigneCommandeClientDto> ligneCommandeClients;
	
	public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
		
		if(commandeClient == null) {
			return null;
		}
		
		return CommandeClientDto.builder().id(commandeClient.getId())
				.code(commandeClient.getCode())
				.dateCommande(commandeClient.getDateCommande())
				.client(ClientDto.fromEntity(commandeClient.getClient()))
				.build();
	}
	
	public static CommandeClient toEntity(CommandeClientDto CommandeClientDto) {
	
		if(CommandeClientDto == null) {
			return null;
		}
		
		CommandeClient commandeClient =new CommandeClient();
		
		commandeClient.setId(CommandeClientDto.getId());
		commandeClient.setCode(CommandeClientDto.getCode());
		commandeClient.setDateCommande(CommandeClientDto.getDateCommande());
		commandeClient.setClient(ClientDto.toEntity(CommandeClientDto.getClient()));
		
		return commandeClient;
		
	}

}
