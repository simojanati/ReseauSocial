package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.Poste;
import com.reseau.model.Utilisateur;

public interface IPosteRepository extends JpaRepository<Poste, Long> {

	@Query("select p from Poste p where p.utilisateur=:x")
	public List<Poste> listePostes(@Param("x")Utilisateur utilisateur);
	
	@Query("select p from Poste p where p.utilisateurTager=:x or p.utilisateur=:x")
	public List<Poste> listeAmisTager(@Param("x")Utilisateur utilisateur);
	
}
