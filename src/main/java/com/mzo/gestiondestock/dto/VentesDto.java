package com.mzo.gestiondestock.dto;

import java.time.Instant;

import com.mzo.gestiondestock.entities.Ventes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VentesDto {

	private Integer id;
	
    private String code;
	
	private Instant dateVente;
	
	private String commentaire;
	
	public static VentesDto fromEntity(Ventes ventes) {
		
		if(ventes == null) {
			return null;
		}
		
		return VentesDto.builder().id(ventes.getId())
				.code(ventes.getCode())
				.dateVente(ventes.getDateVente())
				.commentaire(ventes.getCommentaire())
				.build();
		
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
}