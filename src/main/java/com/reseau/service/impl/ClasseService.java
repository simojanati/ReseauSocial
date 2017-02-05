package com.reseau.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IClasseRepository;
import com.reseau.model.Classe;
import com.reseau.model.Utilisateur;
import com.reseau.service.IClasseService;

@Service
@Transactional
public class ClasseService implements IClasseService {

	@Autowired
	private IClasseRepository classeRepository;
	
	@Override
	public void ajouterClasse(Date dateCreation, String photo, String nom, String description) {
		Classe classe = new Classe(dateCreation, photo, nom, description);
		classeRepository.save(classe);
	}

	@Override
	public void modifierClasse(Long idClasse, Date dateCreation, String photo, String nom,
			String description) {
		Classe classe = afficherUneClasseParId(idClasse);
		classe.setDate_creation(dateCreation);
		classe.setPhoto(photo);
		classe.setNom(nom);
		classe.setDescription(description);
		classeRepository.save(classe);

	}

	@Override
	public void supprimerClasse(Long idClasse) {
		Classe classe = afficherUneClasseParId(idClasse);
		classeRepository.delete(classe);
	}

	@Override
	public Classe afficherUneClasseParId(Long idClasse) {
		Classe classe = classeRepository.findOne(idClasse);
		if (classe==null) throw new RuntimeException("Classe introuvable");
		return classe;
	}

	@Override
	public List<Classe> afficherToutLesClasses() {
		return classeRepository.findAll();
	}

	@Override
	public List<Classe> afficherToutLesClassesParUtilisateur(Utilisateur utilisateur) {
		return classeRepository.afficherListeGroupe(utilisateur);
	}

	@Override
	public int afficherNbeClasses(Utilisateur utilisateur) {
		return classeRepository.afficherNombreGroupe(utilisateur);
	}

}
