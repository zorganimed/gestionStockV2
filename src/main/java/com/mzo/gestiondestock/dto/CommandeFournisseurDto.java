package com.mzo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzo.gestiondestock.entities.CommandeFournisseur;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
public class CommandeFournisseurDto {
	
	private Integer id;
    private String code;
	
	private Instant dateCommande;
	
	 
	private FournisseurDto fournisseur;
	
	@JsonIgnore
 	List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
	
	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
		
		if(commandeFournisseur == null) {
			return null;
		}
		
		CommandeFournisseurDto commandeFournisseurDto = new CommandeFournisseurDto();
		
		commandeFournisseurDto.setId(commandeFournisseur.getId());
		commandeFournisseurDto.setCode(commandeFournisseur.getCode());
		commandeFournisseurDto.setDateCommande(commandeFournisseur.getDateCommande());
		commandeFournisseurDto.setFournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()));
		
		return commandeFournisseurDto;
		
		/*return CommandeFournisseurDto.builder()
				.id(commandeFournisseur.getId())
				.code(commandeFournisseur.getCode())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
				.build();*/
	}
	
	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
		
		if(commandeFournisseurDto == null) {
			return null;
		}
		
		CommandeFournisseur commandeFournisseur =new CommandeFournisseur();
		
		commandeFournisseur.setId(commandeFournisseurDto.getId());
		commandeFournisseur.setCode(commandeFournisseurDto.getCode());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
		
		return commandeFournisseur;
	}

	public CommandeFournisseurDto() {
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

	public FournisseurDto getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(FournisseurDto fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneCommandeFournisseurDto> getLigneCommandeFournisseurs() {
		return ligneCommandeFournisseurs;
	}

	public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs) {
		this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
	}
	
	

}
