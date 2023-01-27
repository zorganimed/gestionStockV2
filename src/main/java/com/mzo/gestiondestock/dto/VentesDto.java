package com.mzo.gestiondestock.dto;

import java.time.Instant;

import com.mzo.gestiondestock.entities.Ventes;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
public class VentesDto {

	private Integer id;
	
    private String code;
	
	private Instant dateVente;
	
	private String commentaire;
	
	public static VentesDto fromEntity(Ventes ventes) {
		
		if(ventes == null) {
			return null;
		}
		
		VentesDto ventesDto = new VentesDto();
		
		ventesDto.setId(ventes.getId());
		ventesDto.setCode(ventes.getCode());
		ventesDto.setDateVente(ventes.getDateVente());
		ventesDto.setCommentaire(ventes.getCommentaire());
		
		return ventesDto;
		
		/*return VentesDto.builder().id(ventes.getId())
				.code(ventes.getCode())
				.dateVente(ventes.getDateVente())
				.commentaire(ventes.getCommentaire())
				.build();*/
		
	}
	
	public static Ventes toEntity(VentesDto ventesDto) {
		
		if(ventesDto == null) {
			return null;
		}
		
		Ventes ventes = new Ventes();
		
		ventes.setId(ventesDto.getId());
		ventes.setCode(ventesDto.getCode());
		ventes.setDateVente(ventesDto.getDateVente());
		ventes.setCommentaire(ventesDto.getCommentaire());
		
		return ventes;
	}

	public VentesDto() {
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

	public Instant getDateVente() {
		return dateVente;
	}

	public void setDateVente(Instant dateVente) {
		this.dateVente = dateVente;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
}
