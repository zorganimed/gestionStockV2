package com.mzo.gestiondestock.dto;

import com.mzo.gestiondestock.entities.Adresse;

/*import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;*/


/*@Builder
@Data*/
public class AdresseDto {
	
	private String adresse1;
	private String adresse2;
	private String ville;
	private String codePostale;
	private String pays;
	
	
	public static AdresseDto fromEntity(Adresse adresse) {
		
		if(adresse == null) {
			return null;
		}
		
		AdresseDto adresseDto = new AdresseDto();
		
		adresseDto.setAdresse1(adresse.getAdresse1());
		adresseDto.setAdresse2(adresse.getAdresse2());
		adresseDto.setCodePostale(adresse.getCodePostale());
		adresseDto.setVille(adresse.getVille());
		adresseDto.setPays(adresse.getPays());
		
		return adresseDto;
		
		/*return AdresseDto.builder().adresse1(adresse.getAdresse1())
				.adresse2(adresse.getAdresse2())
				.codePostale(adresse.getCodePostale())
				.ville(adresse.getVille())
				.pays(adresse.getPays())
				.build();*/
		
	}
	
	public static Adresse toEntity(AdresseDto adresseDto) {
		
		if(adresseDto == null) {
			
			return null;
			
		}
		
		Adresse adresse = new Adresse();
		
		adresse.setAdresse1(adresseDto.getAdresse1());
		adresse.setAdresse2(adresseDto.getAdresse2());
		adresse.setCodePostale(adresseDto.getCodePostale());
		adresse.setVille(adresseDto.getVille());
		adresse.setPays(adresseDto.getPays());
		
		return adresse;
	}

	public AdresseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdresseDto(String adresse1, String adresse2, String ville, String codePostale, String pays) {
		super();
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.ville = ville;
		this.codePostale = codePostale;
		this.pays = pays;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
	


}
