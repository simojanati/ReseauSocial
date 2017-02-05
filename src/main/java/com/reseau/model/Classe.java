package com.reseau.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Classe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5492674902749702832L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClasse;
	private Date date_creation;
	@Column(columnDefinition="/dist/img/groupe.png")
	private String Photo;
	private String Nom;
	private String description;
	@ManyToOne
	@JoinColumn(name="professeur",referencedColumnName="username")
	private Utilisateur utilisateur;

	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Classe(Date date_creation, String photo, String nom,String description) {
		
		this.date_creation = date_creation;
		Photo = photo;
		Nom = nom;
		this.description=description;
	}


	public Long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Long idClasse) {
		this.idClasse = idClasse;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
