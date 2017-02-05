package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Affecter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1163093970744182743L;
	
	@Id
	private AffecterID id;

	public AffecterID getId() {
		return id;
	}

	public void setId(AffecterID id) {
		this.id = id;
	}
	
	public Utilisateur getUtilisateur(){
		return getId().getUtilisateur();
	}
	
	public Competence getCompetence(){
		return getId().getCompetence();
	}
	
	public void setUtilisateur(Utilisateur utilisateur){
		getId().setUtilisateur(utilisateur);
	}
	
	public void setCompetence(Competence competence){
		getId().setCompetence(competence);
	}

	public Affecter(AffecterID id) {
		super();
		this.id = id;
	}

	public Affecter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
