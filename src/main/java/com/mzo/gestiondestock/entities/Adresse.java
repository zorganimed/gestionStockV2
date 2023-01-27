package com.mzo.gestiondestock.entities;

import javax.persistence.Embeddable;
/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;*/

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
@Embeddable
public class Adresse {
	
	private String adresse1;
	private String adresse2;
	private String ville;
	private String codePostale;
	private String pays;
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(String adresse1, String adresse2, String ville, String codePostale, String pays) {
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
