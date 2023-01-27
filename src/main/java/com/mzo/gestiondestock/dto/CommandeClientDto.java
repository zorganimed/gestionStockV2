package com.mzo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.CommandeClient;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
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
		
		CommandeClientDto commandeClientDto = new CommandeClientDto();
		
		commandeClientDto.setId(commandeClient.getId());
		commandeClientDto.setCode(commandeClient.getCode());
		commandeClientDto.setDateCommande(commandeClient.getDateCommande());
		commandeClientDto.setClient(ClientDto.fromEntity(commandeClient.getClient()));
				
		return commandeClientDto;
		
		/*return CommandeClientDto.builder().id(commandeClient.getId())
				.code(commandeClient.getCode())
				.dateCommande(commandeClient.getDateCommande())
				.client(ClientDto.fromEntity(commandeClient.getClient()))
				.build();*/
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

	public CommandeClientDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Instant getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Instant dateCommande) {
		this.dateCommande = dateCommande;
	}

	public ClientDto getClient() {
		return client;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public List<LigneCommandeClientDto> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(List<LigneCommandeClientDto> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}
	
	

}
