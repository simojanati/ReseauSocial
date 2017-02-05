package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.Classe;
import com.reseau.model.Utilisateur;

public interface IClasseRepository extends JpaRepository<Classe, Long> {

	@Query("select count(a) from Classe a where a.utilisateur=:x")
	public int afficherNombreGroupe(@Param("x")Utilisateur utilisateur);
	
	@Query("select a from Classe a where a.utilisateur=:x")
	public List<Classe> afficherListeGroupe(@Param("x")Utilisateur utilisateur);
}
