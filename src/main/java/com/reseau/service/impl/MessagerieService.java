package com.reseau.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IMessagerieRepository;
import com.reseau.model.Messagerie;
import com.reseau.model.Utilisateur;
import com.reseau.service.IMessagerieService;

@Service
@Transactional
public class MessagerieService implements IMessagerieService {

	@Autowired
	private IMessagerieRepository messagerieRepository;
	
	@Override
	public void ajouterMessage(String message, String objet, Utilisateur utilisateurEnvoie, Utilisateur utilisateurRecoie) {
		Messagerie messagerie = new Messagerie(new Date(), message, objet, utilisateurEnvoie, utilisateurRecoie, false);
		messagerieRepository.save(messagerie);
	}

	@Override
	public void supprimerMessage(Long idMessagerie) {
		Messagerie messagerie = afficherMessage(idMessagerie);
		messagerieRepository.delete(messagerie);
	}

	@Override
	public void changerEtatVu(Long idMessagerie) {
		Messagerie messagerie = afficherMessage(idMessagerie);
		messagerie.setVu(true);
		messagerieRepository.save(messagerie);
	}

	@Override
	public List<Messagerie> afficherConversation(Utilisateur utilisateur1, Utilisateur utilisateur2) {
		return messagerieRepository.findAll();
	}

	@Override
	public Messagerie afficherMessage(Long idMessagerie) {
		Messagerie messagerie = messagerieRepository.findOne(idMessagerie);
		return messagerie;
	}

	@Override
	public int afficherNbrMessageNonVu(Utilisateur utilisateur) {
		return messagerieRepository.afficherNombreGroupe(utilisateur);
	}

	@Override
	public List<Messagerie> afficherMessagesRecue(Utilisateur utilisateur) {
		return messagerieRepository.afficherLesMessageRecue(utilisateur);
	}

	@Override
	public List<Messagerie> afficherMessagesEnvoyer(Utilisateur utilisateur) {
		return messagerieRepository.afficherLesMessageEnvoyer(utilisateur);
	}

}
