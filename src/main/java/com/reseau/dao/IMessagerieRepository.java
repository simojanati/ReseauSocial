package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.Messagerie;
import com.reseau.model.Utilisateur;

public interface IMessagerieRepository extends JpaRepository<Messagerie, Long> {
	
	@Query("select count(a) from Messagerie a where a.utilisateurRecoie=:x and a.vu=false")
	public int afficherNombreGroupe(@Param("x")Utilisateur utilisateur);
	
	@Query("select a from Messagerie a where a.utilisateurEnvoie=:x")
	public List<Messagerie> afficherLesMessageEnvoyer(@Param("x")Utilisateur utilisateur);
	
	@Query("select a from Messagerie a where a.utilisateurRecoie=:x")
	public List<Messagerie> afficherLesMessageRecue(@Param("x")Utilisateur utilisateur);
}
