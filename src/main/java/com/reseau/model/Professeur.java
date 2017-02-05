package com.reseau.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Professeur")
public class Professeur extends Utilisateur{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7918356106701842920L;
	
	private String ecoles;

	public String getEcoles() {
		return ecoles;
	}

	public void setEcoles(String ecoles) {
		this.ecoles = ecoles;
	}

	public Professeur(String nom, String prenom, String username, String password, Date dateNaissance, String tel,
			String adresse, String photo, String pays, String ville, String branche, boolean active, String fonction,
			java.sql.Date dateCreation, String ecoles) {
		super(nom, prenom, username, password, dateNaissance, tel, adresse, photo, pays, ville, branche, active,
				fonction, dateCreation);
		this.ecoles = ecoles;
	}

	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

	
