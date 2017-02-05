package com.reseau.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Type implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6717682030686403839L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String message;
	@OneToMany
	@JoinColumn(name="idType",referencedColumnName="idType")
	private List<Poste> postes;
	
	
	public Type(String message) {
		
		this.message = message;
	}
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
