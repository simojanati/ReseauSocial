package com.reseau.service;

import java.util.List;

import com.reseau.model.Commenter;
import com.reseau.model.Poste;
import com.reseau.model.Utilisateur;

public interface ICommenterService {
	
	public void ajouterCommentaire(Utilisateur utilisateur, Poste poste, String message);
	public void supprimerCommentaire(Long idCommentaire);
	public List<Commenter> afficherToutLesCommentaire();
	public List<Commenter> afficherListeCommentaireParPoste(Poste poste);

}
