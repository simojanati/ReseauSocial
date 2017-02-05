package com.reseau.service;

import java.util.List;

import com.reseau.model.Classe;
import com.reseau.model.Poste;
import com.reseau.model.Relation;

public interface IRelationService {

	public void ajouterRelation(Classe classe, Poste poste);
	public void supprimerRelation(Classe classe, Poste poste);
	public Relation afficherUneRelation(Classe classe, Poste poste);
	public List<Relation> afficherToutLesRelation();
	public List<Poste> afficherPostesParClasse(Classe classe);
}
