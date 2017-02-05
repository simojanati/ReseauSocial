package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.EtatAmis;
import com.reseau.model.EtatAmisID;
import com.reseau.model.Utilisateur;

public interface IEtatAmisRepository extends JpaRepository<EtatAmis, EtatAmisID> {

	@Query("select count(e) from EtatAmis e where (e.etatAmisID.utilisateurInviteur=:x or e.etatAmisID.utilisateurInviter=:x) and e.Etat=:y")
	public int afficherNombreAmis(@Param("x")Utilisateur utilisateur,@Param("y")String etat);
	
	@Query("select e.etatAmisID.utilisateurInviter from EtatAmis e where e.etatAmisID.utilisateurInviteur=:x and e.Etat=:y")
	public List<Utilisateur> afficherListeDesAmisInviter(@Param("x")Utilisateur utilisateur,@Param("y")String etat);

	@Query("select e.etatAmisID.utilisateurInviteur from EtatAmis e where e.etatAmisID.utilisateurInviter=:x and e.Etat=:y")
	public List<Utilisateur> afficherListeDesAmisInviteur(@Param("x")Utilisateur utilisateur,@Param("y")String etat);
	
	@Query("select e from EtatAmis e where (e.etatAmisID.utilisateurInviteur=:x or e.etatAmisID.utilisateurInviter=:x) and (e.etatAmisID.utilisateurInviteur=:y or e.etatAmisID.utilisateurInviter=:y)")
	public EtatAmis afficherEtatAmis(@Param("x")Utilisateur utilisateur1,@Param("y")Utilisateur utilisateur2);
}
