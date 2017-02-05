package com.reseau.service;

import java.util.List;

import com.reseau.model.EtatAmis;
import com.reseau.model.Utilisateur;

public interface IEtatAmisService  {

	public void ajouterEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter, String etat);
	public void modifierEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter, String etat);
	public void supprimerEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter);
	public EtatAmis afficherEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter);
	public int afficherNombreAmisAccepter(Utilisateur utilisateur);
	public int afficherNombreAmisRefuser(Utilisateur utilisateur);
	public List<EtatAmis> afficherLesEtatsAmis();
	public List<Utilisateur> afficherLesAmis(Utilisateur utilisateur);
}
