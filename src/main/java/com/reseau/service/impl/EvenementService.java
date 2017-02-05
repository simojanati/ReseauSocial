package com.reseau.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IEvenementRepository;
import com.reseau.model.Evenement;
import com.reseau.service.IEvenementService;

@Service
@Transactional
public class EvenementService implements IEvenementService {

	@Autowired
	private IEvenementRepository evenementRepository;

	@Override
	public void ajouterEvenement(String message, String nom, String jour, String mois) {
		Evenement evenement = new Evenement(message, nom, jour, mois);
		evenementRepository.save(evenement);
	}

	@Override
	public void modifierEvenement(Long idEvenement, String message, String nom, String jour, String mois) {
		Evenement evenement = afficherUnEvenement(idEvenement);
		evenement.setMessage(message);
		evenement.setNom(nom);
		evenement.setJour(jour);
		evenement.setMois(mois);
		evenementRepository.save(evenement);
	}

	@Override
	public void supprimerEvenement(Long idEvenement) {
		Evenement evenement = afficherUnEvenement(idEvenement);
		evenementRepository.delete(evenement);
	}

	@Override
	public Evenement afficherUnEvenement(Long idEvenement) {
		Evenement evenement = evenementRepository.findOne(idEvenement);
		if(evenement==null) throw new RuntimeException("Evenement introuvable");
		return evenement;
	}

	@Override
	public List<Evenement> afficherToutLesEvenement() {
		return evenementRepository.findAll();
	}
	
	

}
