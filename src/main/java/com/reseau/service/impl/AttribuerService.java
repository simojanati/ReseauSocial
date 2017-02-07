package com.reseau.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IAttribuerRepository;
import com.reseau.model.Attribuer;
import com.reseau.model.AttribuerID;
import com.reseau.model.Classe;
import com.reseau.model.Etudiant;
import com.reseau.model.Utilisateur;
import com.reseau.service.IAttribuerService;
@Service
@Transactional
public class AttribuerService implements IAttribuerService {

	@Autowired
	private IAttribuerRepository attribuerRepository;
	
	@Override
	public int nbrGroupe(Utilisateur utilisateur) {
		return attribuerRepository.afficherNombreGroupe(utilisateur);
	}

	@Override
	public List<Classe> afficherLesGroupes(Utilisateur utilisateur){
		return attribuerRepository.afficherNomGroupe(utilisateur);
	}

	@Override
	public int nbrEtudiant(Classe classe) {
		return attribuerRepository.afficherNombreEtudiants(classe);
	}

	@Override
	public List<Etudiant> afficherLesEtudiants(Classe classe) {
		return attribuerRepository.afficherLesEtudiant(classe);
	}

	@Override
	public void ajouterMembre(Etudiant etudiant, Classe classe) {
		AttribuerID attribuerID = new AttribuerID(etudiant, classe);
		Attribuer attribuer = new Attribuer(attribuerID, new Date());
		attribuerRepository.save(attribuer);
	}
}
