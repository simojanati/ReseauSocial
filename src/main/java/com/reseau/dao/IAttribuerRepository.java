package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.Attribuer;
import com.reseau.model.AttribuerID;
import com.reseau.model.Classe;
import com.reseau.model.Etudiant;
import com.reseau.model.Utilisateur;

public interface IAttribuerRepository extends JpaRepository<Attribuer, AttribuerID> {

	@Query("select count(a) from Attribuer a where a.attribuerID.idEtudiant=:x")
	public int afficherNombreGroupe(@Param("x")Utilisateur utilisateur);
	
	@Query("select a.attribuerID.idClasse from Attribuer a where a.attribuerID.idEtudiant=:x")
	public List<Classe> afficherNomGroupe(@Param("x")Utilisateur utilisateur);
	
	@Query("select count(a) from Attribuer a where a.attribuerID.idClasse=:x")
	public int afficherNombreEtudiants(@Param("x")Classe classe);
	
	@Query("select a.attribuerID.idEtudiant from Attribuer a where a.attribuerID.idClasse=:x")
	public List<Etudiant> afficherLesEtudiant(@Param("x")Classe classe);
	
}
