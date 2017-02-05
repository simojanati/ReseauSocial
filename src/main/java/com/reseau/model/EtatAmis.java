package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class EtatAmis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2945379573748997421L;
	@Id
	private EtatAmisID etatAmisID;
	private String Etat;
	
	public EtatAmisID getEtatAmisID() {
		return etatAmisID;
	}
	public void setEtatAmisID(EtatAmisID etatAmisID) {
		this.etatAmisID = etatAmisID;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	
	public Utilisateur getUtilisateurInviteur(){
		return getEtatAmisID().getUtilisateurInviteur();
	}
	
	public Utilisateur getUtilisateurInviter(){
		return getEtatAmisID().getUtilisateurInviter();
	}
	
	public void setUtilisateurInviteur(Utilisateur utilisateurInviteur){
		getEtatAmisID().setUtilisateurInviteur(utilisateurInviteur);
	}
	
	public void setUtilisateurInviter(Utilisateur utilisateurInviter){
		getEtatAmisID().setUtilisateurInviter(utilisateurInviter);
	}
	
	public EtatAmis(EtatAmisID etatAmisID, String etat) {
		super();
		this.etatAmisID = etatAmisID;
		Etat = etat;
	}
	public EtatAmis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
