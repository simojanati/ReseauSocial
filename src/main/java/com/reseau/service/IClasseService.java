package com.reseau.service;

import java.util.Date;
import java.util.List;

import com.reseau.model.Classe;
import com.reseau.model.Utilisateur;

public interface IClasseService {

	public void ajouterClasse(Date dateCreation, String photo, String nom, String description);
	public void modifierClasse(Long idClasse, Date dateCreation, String photo, String nom, String description);
	public void supprimerClasse(Long idClasse);
	public Classe afficherUneClasseParId(Long idClasse);
	public List<Classe> afficherToutLesClasses();
	
	public List<Classe> afficherToutLesClassesParUtilisateur(Utilisateur utilisateur);
	public int afficherNbeClasses(Utilisateur utilisateur);
	
	
}
