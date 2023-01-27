package com.mzo.gestiondestock.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.Data;


//@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{
	
	@Id 
    @GeneratedValue
	private Integer id;
	
	@CreatedDate
	@Column(name = "creationDate", nullable = false)
	@JsonIgnore
	private Instant creationDate;
	
	@LastModifiedDate
	@Column(name = "lastUpdateDate")
	@JsonIgnore
	private Instant lastUpdateDate;
	
	

	public AbstractEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractEntity(Integer id, Instant creationDate, Instant lastUpdateDate) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public Instant getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Instant lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	

}
