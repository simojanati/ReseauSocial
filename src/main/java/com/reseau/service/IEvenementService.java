package com.reseau.service;

import java.util.List;

import com.reseau.model.Evenement;

public interface IEvenementService {
	
	public void ajouterEvenement(String message, String nom, String jour, String mois);
	public void modifierEvenement(Long idEvenement, String message, String nom, String jour, String mois);
	public void supprimerEvenement(Long idEvenement);
	public Evenement afficherUnEvenement(Long idEvenement);
	public List<Evenement> afficherToutLesEvenement();

}
