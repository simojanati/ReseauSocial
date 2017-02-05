package com.reseau.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IPosteRepository;
import com.reseau.model.Poste;
import com.reseau.model.Type;
import com.reseau.model.Utilisateur;
import com.reseau.service.IPosteService;
@Service
@Transactional
public class PosteService implements IPosteService {

	@Autowired
	private IPosteRepository posteRepository;
	
	@Override
	public Poste ajouterPoste(String statut, Date date, Type type, String lien, String nomLien, Utilisateur utilisateur, Utilisateur utilisateurTager, boolean groupe) {
		Poste poste = new Poste(statut, date, type, lien,nomLien,groupe);
		poste.setUtilisateur(utilisateur);
		poste.setUtilisateurTager(utilisateurTager);
		posteRepository.save(poste);
		return poste;
	}

	@Override
	public void modifierPoste(Long idPoste, String statut, Date date, Type type, String lien, String nomLien, Utilisateur utilisateur, Utilisateur utilisateurTager, boolean groupe) {
		Poste poste = afficherUnPoste(idPoste);
		poste.setDate(date);
		poste.setStatut(statut);
		poste.setType(type);
		poste.setUtilisateur(utilisateur);
		poste.setLien(lien);
		poste.setNomLien(nomLien);
		poste.setUtilisateurTager(utilisateurTager);
		poste.setGroupe(groupe);
		posteRepository.save(poste);
	}

	@Override
	public void supprimerPoste(Long idPoste) {
		Poste poste = afficherUnPoste(idPoste);
		posteRepository.delete(poste);
	}

	@Override
	public Poste afficherUnPoste(Long idPoste) {
		Poste poste = posteRepository.findOne(idPoste);
		if(poste==null) throw new RuntimeException("Poste introuvable");
		return poste;
	}

	@Override
	public List<Poste> afficherToutLesPostes() {
		return posteRepository.findAll();
	}

	@Override
	public List<Poste> afficherPostesAmis(Utilisateur utilisateur, List<Utilisateur> utilisateurs) {
		List<Poste> postes = posteRepository.listePostes(utilisateur);
		for (Utilisateur u : utilisateurs) {
			List<Poste> p = posteRepository.listePostes(u);
			postes.addAll(p);
		}
		return postes;
	}
	
	@Override
	public List<Poste> afficherAmisTager(Utilisateur utilisateur) {
		return posteRepository.listeAmisTager(utilisateur);
	}

}
