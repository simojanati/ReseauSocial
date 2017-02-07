package com.reseau.service;

import java.util.List;

import com.reseau.model.Classe;
import com.reseau.model.Etudiant;
import com.reseau.model.Utilisateur;

public interface IAttribuerService {

	public void ajouterMembre(Etudiant etudiant, Classe classe);
	public int nbrGroupe(Utilisateur utilisateur);
	public List<Classe> afficherLesGroupes(Utilisateur utilisateur);
	public int nbrEtudiant(Classe classe);
	public List<Etudiant> afficherLesEtudiants(Classe classe);
}
