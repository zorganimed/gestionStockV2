package com.mzo.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

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
	
    private Integer idEntreprise;
    
    private List<LigneVenteDto> ligneVentes;
	
	public static VentesDto fromEntity(Ventes ventes) {
		
		if(ventes == null) {
			return null;
		}
		
		VentesDto ventesDto = new VentesDto();
		
		ventesDto.setId(ventes.getId());
		ventesDto.setCode(ventes.getCode());
		ventesDto.setDateVente(ventes.getDateVente());
		ventesDto.setCommentaire(ventes.getCommentaire());
		ventesDto.setIdEntreprise(ventes.getIdEntreprise());
		
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
		ventes.setIdEntreprise(ventesDto.getIdEntreprise());
		
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
	
	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public List<LigneVenteDto> getLigneVentes() {
		return ligneVentes;
	}

	public void setLigneVentes(List<LigneVenteDto> ligneVentes) {
		this.ligneVentes = ligneVentes;
	}

	
}
