package com.reseau.service;

import java.util.Date;
import java.util.List;

import com.reseau.model.Utilisateur;

public interface IUtilisateurService  {

	public void ajouterUtilisateur(String nom, String prenom, String login, String mdp, Date dateNaissance, String tel, String adresse,
			String photo, String pays, String ville, String branche,String ecole, String ecoles, boolean active, String fonction,
			java.sql.Date dateCreation, String typeUtilisateur);
	public void modifierUtilisateur(String nom, String prenom, String login, String mdp, Date dateNaissance, 
			String tel, String adresse, String photo, String pays, String ville, String branche,String ecole, String ecoles,
			String fonction, java.sql.Date dateCreation, boolean active);
	public void supprimerUtilisateur(String login);
	public Utilisateur afficherUnUtilisateur(String login);
	public List<Utilisateur> afficherToutLesUtilisateurs();
	public Utilisateur getConnectedManInfo();
	
}
