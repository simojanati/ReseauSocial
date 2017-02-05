package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Competence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5693116539916155557L;
	
	@Id
	private String nom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Competence(String nom) {
		super();
		this.nom = nom;
	}
	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
