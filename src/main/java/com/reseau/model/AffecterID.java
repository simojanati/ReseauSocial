package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AffecterID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1486762208337867714L;
	
	@ManyToOne
	@JoinColumn(name="username",referencedColumnName="username")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="nomCompetence",referencedColumnName="nom")
	private Competence competence;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public AffecterID(Utilisateur utilisateur, Competence competence) {
		super();
		this.utilisateur = utilisateur;
		this.competence = competence;
	}
	public AffecterID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
