package com.reseau.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.ICommenterRepository;
import com.reseau.model.Commenter;
import com.reseau.model.Poste;
import com.reseau.model.Utilisateur;
import com.reseau.service.ICommenterService;

@Service
@Transactional
public class CommenterService implements ICommenterService {

	@Autowired
	private ICommenterRepository commenterRepository;
	
	@Override
	public void ajouterCommentaire(Utilisateur utilisateur, Poste poste, String message) {
		Commenter commenter = new Commenter(message);
		commenter.setPoste(poste);
		commenter.setUtilisateur(utilisateur);
		commenterRepository.save(commenter);
	}


	@Override
	public void supprimerCommentaire(Long idCommentaire) {
		commenterRepository.delete(idCommentaire);
	}

	@Override
	public List<Commenter> afficherToutLesCommentaire() {
		return commenterRepository.findAll();
	}

	@Override
	public List<Commenter> afficherListeCommentaireParPoste(Poste poste) {
		return commenterRepository.afficherListeCommentaireParPoste(poste);
	}

}
