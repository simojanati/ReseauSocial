package com.reseau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IEtatAmisRepository;
import com.reseau.model.EtatAmis;
import com.reseau.model.EtatAmisID;
import com.reseau.model.Utilisateur;
import com.reseau.service.IEtatAmisService;
@Service
@Transactional
public class EtatAmisService implements IEtatAmisService {

	@Autowired
	private IEtatAmisRepository etatAmisRepository;
	
	@Override
	public void ajouterEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter, String etat) {
		EtatAmisID id = new EtatAmisID(utilisateurInviteur, utilisateurInviter);
		EtatAmis etatAmis = new EtatAmis(id, etat);
		etatAmisRepository.save(etatAmis);
	}

	@Override
	public void modifierEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter, String etat) {
		EtatAmis etatAmis = afficherEtatAmis(utilisateurInviteur, utilisateurInviter);
		etatAmis.setEtat(etat);
		etatAmisRepository.save(etatAmis);
	}

	@Override
	public void supprimerEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter) {
		EtatAmis etatAmis = afficherEtatAmis(utilisateurInviteur, utilisateurInviter);
		etatAmisRepository.delete(etatAmis);
	}

	@Override
	public EtatAmis afficherEtatAmis(Utilisateur utilisateurInviteur, Utilisateur utilisateurInviter) {
		EtatAmis etatAmis = etatAmisRepository.afficherEtatAmis(utilisateurInviteur, utilisateurInviter);
		if(etatAmis!=null){
			if(etatAmis.getEtat().equals("refuser")){
				etatAmis = null;
			}
		}
		return etatAmis;
	}

	@Override
	public int afficherNombreAmisAccepter(Utilisateur utilisateur) {
		return etatAmisRepository.afficherNombreAmis(utilisateur, "accepter");
	}

	@Override
	public int afficherNombreAmisRefuser(Utilisateur utilisateur) {
		return etatAmisRepository.afficherNombreAmis(utilisateur, "refuser");
	}

	@Override
	public List<EtatAmis> afficherLesEtatsAmis() {
		return etatAmisRepository.findAll();
	}

	@Override
	public List<Utilisateur> afficherLesAmis(Utilisateur utilisateur) {
		List<Utilisateur> utilisateursInviter = etatAmisRepository.afficherListeDesAmisInviter(utilisateur, "accepter");
		List<Utilisateur> utilisateursInviteur = etatAmisRepository.afficherListeDesAmisInviteur(utilisateur, "accepter");
		List<Utilisateur> utilisateurs = new ArrayList<>();
		utilisateurs.addAll(utilisateursInviter);
		utilisateurs.addAll(utilisateursInviteur);
		return utilisateurs;
	}

}
