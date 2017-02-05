package com.reseau.service;

import java.util.Date;
import java.util.List;

import com.reseau.model.Poste;
import com.reseau.model.Type;
import com.reseau.model.Utilisateur;

public interface IPosteService {

	public Poste ajouterPoste(String statut, Date date, Type type, String lien, String nomLien, Utilisateur utilisateur, Utilisateur utilisateurTager, boolean groupe);
	public void modifierPoste(Long idPoste, String statut, Date date, Type type, String lien, String nomLien, Utilisateur utilisateur, Utilisateur utilisateurTager, boolean groupe);
	public void supprimerPoste(Long idPoste);
	public Poste afficherUnPoste(Long idPoste);
	public List<Poste> afficherToutLesPostes();
	public List<Poste> afficherPostesAmis(Utilisateur utilisateur, List<Utilisateur> utilisateurs);
	public List<Poste> afficherAmisTager(Utilisateur utilisateur);
}
