package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EtatAmisID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8857966409664975146L;
	
	@ManyToOne
	@JoinColumn(name="usernameUtilisateurInviteur",referencedColumnName="username")
	private Utilisateur utilisateurInviteur;
	@ManyToOne
	@JoinColumn(name="usernameUtilisateurInviter",referencedColumnName="username")
	private Utilisateur utilisateurInviter;
	
	
	public Utilisateur getUtilisateurInviteur() {
		return utilisateurInviteur;
	}
	public void setUtilisateurInviteur(Utilisateur utilisateurInviteur) {
		this.utilisateurInviteur = utilisateurInviteur;
	}
	public Utilisateur getUtilisateurInviter() {
		return utilisateurInviter;
	}
	public void setUtilisateurInviter(Utilisateur utilisateurInviter) {
		this.utilisateurInviter = utilisateurInviter;
	}
	public EtatAmisID(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter) {
		this.utilisateurInviteur = utilisateurInviteur;
		this.utilisateurInviter = utilisateurInviter;
	}
	public EtatAmisID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
