package com.mzo.gestiondestock.dto;


import com.mzo.gestiondestock.entities.Roles;

/*import lombok.Builder;
import lombok.Data;*/

/*@Data
@Builder*/
public class RolesDto {

	private Integer id;
	
    private String roleName;
	

	private UtilisateurDto utilisateur;
	
    private Integer idEntreprise;
	
	public static RolesDto fromEntity(Roles roles) {
		
		if(roles == null) {
			return null;
		}
		
		RolesDto rolesDto =new RolesDto();
		
		rolesDto.setId(roles.getId());
		rolesDto.setRoleName(roles.getRoleName());
		rolesDto.setUtilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()));
		rolesDto.setIdEntreprise(roles.getIdEntreprise());
		
		return rolesDto;
		
		/*return RolesDto.builder().id(roles.getId())
				.roleName(roles.getRoleName())
				.utilisateur(UtilisateurDto.fromEntity(roles.getUtilisateur()))
				.build();*/
	}
	
	public static Roles toEntity(RolesDto rolesDto) {
		
		if(rolesDto == null) {
			return null;
		}
		
		Roles roles= new Roles();
		
		roles.setId(rolesDto.getId());
		roles.setRoleName(rolesDto.getRoleName());
		roles.setUtilisateur(UtilisateurDto.toEntity(rolesDto.getUtilisateur()));
		roles.setIdEntreprise(rolesDto.getIdEntreprise());
		
		return roles;
	}

	public RolesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UtilisateurDto getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDto utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}	
}
