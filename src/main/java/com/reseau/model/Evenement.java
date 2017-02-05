package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evenement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 604349128987013789L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvenement;
	private String message;
	private String Nom;
	private String jour;
	private String Mois;
	
	public Evenement(String message, String nom, String jour, String mois) {
		
		this.message = message;
		this.Nom = nom;
		this.jour = jour;
		this.Mois = mois;
	}

	public Long getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Long idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getMois() {
		return Mois;
	}

	public void setMois(String mois) {
		Mois = mois;
	}

	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
