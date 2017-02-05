package com.reseau.service;

import java.util.List;

import com.reseau.model.Messagerie;
import com.reseau.model.Utilisateur;

public interface IMessagerieService {
	
	public void ajouterMessage(String message, String objet, Utilisateur utilisateurEnvoie, Utilisateur utilisateurRecoie);
	public void supprimerMessage(Long idMessagerie);
	public void changerEtatVu(Long idMessagerie);
	public List<Messagerie> afficherConversation(Utilisateur utilisateur1, Utilisateur utilisateur2);
	public Messagerie afficherMessage(Long idMessagerie);
	public int afficherNbrMessageNonVu(Utilisateur utilisateur);
	public List<Messagerie> afficherMessagesRecue(Utilisateur utilisateur);
	public List<Messagerie> afficherMessagesEnvoyer(Utilisateur utilisateur);
	
}
