package com.reseau.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.IUtilisateurRepository;
import com.reseau.model.Etudiant;
import com.reseau.model.Professeur;
import com.reseau.model.Utilisateur;
import com.reseau.security.MD5;
import com.reseau.service.IUtilisateurService;
@Service
@Transactional
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	private IUtilisateurRepository utilisateurRepository;
	
	@Override
	public void ajouterUtilisateur(String nom, String prenom, String login, String mdp, Date dateNaissance, String tel,
		String adresse, String photo, String pays, String ville, String branche, String ecole, String ecoles, boolean active,
		String fonction, java.sql.Date dateCreation, String typeUtilisateur) {
		Utilisateur utilisateur = utilisateurRepository.findOne(login);;
		if(utilisateur!=null) throw new RuntimeException("Utilisateur exist déja");
		String password = MD5.getMD5(mdp);
		photo = "../dist/img/"+photo;
		if(typeUtilisateur.equals("Etudiant")){
			utilisateur = new Etudiant(nom, prenom, login, password, dateNaissance, tel, adresse, photo, pays, ville, branche, active, fonction, dateCreation, ecole);
		}else if(typeUtilisateur.equals("Professeur")){
			utilisateur = new Professeur(nom, prenom, login, password, dateNaissance, tel, adresse, photo, pays, ville, branche, active, fonction, dateCreation, ecoles);
		}
		utilisateurRepository.save(utilisateur);

	}

	@Override
	public void modifierUtilisateur(String nom, String prenom, String login, String mdp,
			Date dateNaissance, String tel, String adresse, String photo, String pays, String ville, String branche, String ecole,
			String ecoles, String fonction, java.sql.Date dateCreation, boolean active) {
		Utilisateur utilisateur = afficherUnUtilisateur(login);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setPassword(MD5.getMD5(mdp));
		utilisateur.setDateNaissance(dateNaissance);
		utilisateur.setTel(tel);
		utilisateur.setAdresse(adresse);
		photo = "../dist/img/"+photo;
		utilisateur.setPhoto(photo);
		utilisateur.setPays(pays);
		utilisateur.setVille(ville);
		utilisateur.setBranche(branche);
		utilisateur.setActive(active);
		utilisateur.setFonction(fonction);
		utilisateur.setDateCreation(dateCreation);
		if(utilisateur instanceof Etudiant){
			((Etudiant) utilisateur).setEcole(ecole);
		}else if(utilisateur instanceof Professeur){
			((Professeur) utilisateur).setEcoles(ecoles);
		}
		utilisateurRepository.save(utilisateur);
	}

	@Override
	public void supprimerUtilisateur(String login) {
		Utilisateur utilisateur = afficherUnUtilisateur(login);
		utilisateurRepository.delete(utilisateur);
	}

	@Override
	public Utilisateur afficherUnUtilisateur(String login) {
		Utilisateur utilisateur = utilisateurRepository.findOne(login);
		return utilisateur;
	}

	@Override
	public List<Utilisateur> afficherToutLesUtilisateurs() {
		return utilisateurRepository.findAll();
	}
	
	@Override
	public Utilisateur getConnectedManInfo() {
			User man = (User) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			String username = man.getUsername();
			return afficherUnUtilisateur(username);
	}

}
