package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reseau.model.Commenter;
import com.reseau.model.Poste;

public interface ICommenterRepository extends JpaRepository<Commenter, Long> {

	@Query("select c from Commenter c where c.poste=:x")
	public List<Commenter> afficherListeCommentaireParPoste(Poste poste);
}
