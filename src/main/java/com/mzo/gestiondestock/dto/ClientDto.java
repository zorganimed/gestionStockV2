package com.mzo.gestiondestock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.Client;

/*import lombok.Builder;
import lombok.Data;*/

/*@Builder
@Data*/
public class ClientDto {

	private Integer id;
	
    private String nom;
	
	private String prenom;
	
 	private AdresseDto adresse;
	
	private String photo;
	
	private String mail;
	
	private String numTel;
	
	private Integer idEntreprise;
	
	
	@JsonIgnore
 	private List<CommandeClientDto> commandeClients;
	
	public static ClientDto fromEntity(Client client) {
		
		if(client == null) {
			return null;
		}
		
		ClientDto clientDto = new ClientDto();
		
		clientDto.setId(client.getId());
		clientDto.setNom(client.getNom());
		clientDto.setPrenom(client.getPrenom());
		clientDto.setPhoto(client.getPhoto());
		clientDto.setMail(client.getMail());
		clientDto.setNumTel(client.getNumTel());
		clientDto.setAdresse(AdresseDto.fromEntity(client.getAdresse()));
		clientDto.setIdEntreprise(client.getIdEntreprise());
		
		return clientDto;
 		
		/*return ClientDto.builder().id(client.getId())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.photo(client.getPhoto())
				.mail(client.getMail())
				.numTel(client.getNumTel())
				.adresse(AdresseDto.fromEntity(client.getAdresse()))
				.build();*/
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
		client.setIdEntreprise(clientDto.getIdEntreprise());
		
		 
		return client;
		
	}

	public ClientDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public AdresseDto getAdresse() {
		return adresse;
	}

	public void setAdresse(AdresseDto adresse) {
		this.adresse = adresse;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public List<CommandeClientDto> getCommandeClients() {
		return commandeClients;
	}

	public void setCommandeClients(List<CommandeClientDto> commandeClients) {
		this.commandeClients = commandeClients;
	}
	
	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	
	
	
}
