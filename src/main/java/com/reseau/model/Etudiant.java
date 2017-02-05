package com.reseau.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Etudiant")
public class Etudiant extends Utilisateur{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5804735896189330273L;

	private String ecole;
	

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String nom, String prenom, String username, String password, Date dateNaissance, String tel,
			String adresse, String photo, String pays, String ville, String branche, boolean active, String fonction,
			java.sql.Date dateCreation, String ecole) {
		super(nom, prenom, username, password, dateNaissance, tel, adresse, photo, pays, ville, branche, active,
				fonction, dateCreation);
		this.ecole = ecole;
	}

	


	
	
}
