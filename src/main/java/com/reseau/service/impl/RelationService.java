package com.reseau.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IRelationRepository;
import com.reseau.model.Classe;
import com.reseau.model.Poste;
import com.reseau.model.Relation;
import com.reseau.model.RelationID;
import com.reseau.service.IRelationService;

@Service
@Transactional
public class RelationService implements IRelationService {

	@Autowired
	private IRelationRepository relationRepository;
	
	@Override
	public void ajouterRelation(Classe classe, Poste poste) {
		RelationID id = new RelationID(classe, poste);
		Relation relation = new Relation(id);
		relationRepository.save(relation);
	}

	@Override
	public void supprimerRelation(Classe classe, Poste poste) {
		Relation relation = afficherUneRelation(classe, poste);
		if(relation==null) throw new RuntimeException("Relation introuvable");
		relationRepository.delete(relation);
	}

	@Override
	public Relation afficherUneRelation(Classe classe, Poste poste) {
		RelationID id = new RelationID(classe, poste);
		return relationRepository.findOne(id);
	}

	@Override
	public List<Relation> afficherToutLesRelation() {
		return relationRepository.findAll();
	}

	@Override
	public List<Poste> afficherPostesParClasse(Classe classe) {
		return relationRepository.afficherPostes(classe);
	}

}
