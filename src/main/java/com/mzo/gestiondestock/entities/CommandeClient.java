package com.mzo.gestiondestock.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;*/

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)*/
@Entity
@Table(name = "commandeclient")
public class CommandeClient extends AbstractEntity{
	
	private String code;
	private Instant dateCommande;
	private Integer idEntreprise;
	
	@ManyToOne
	@JoinColumn(name = "idclient")
	private Client client;
	
	@OneToMany(mappedBy = "commandeclient")
	private List<LigneCommandeClient> ligneCommandeClients;

	public CommandeClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeClient(Integer id, Instant creationDate, Instant lastUpdateDate, String code, Instant dateCommande,
			Integer idEntreprise, Client client, List<LigneCommandeClient> ligneCommandeClients) {
		super(id, creationDate, lastUpdateDate);
		this.code = code;
		this.dateCommande = dateCommande;
		this.idEntreprise = idEntreprise;
		this.client = client;
		this.ligneCommandeClients = ligneCommandeClients;
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

	public Integer getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Integer idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommandeClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}

	public void setLigneCommandeClients(List<LigneCommandeClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}
	
	

}
