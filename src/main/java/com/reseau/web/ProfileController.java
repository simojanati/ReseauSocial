package com.reseau.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reseau.model.Classe;
import com.reseau.model.EtatAmis;
import com.reseau.model.Etudiant;
import com.reseau.model.Poste;
import com.reseau.model.Professeur;
import com.reseau.model.Utilisateur;
import com.reseau.service.IAttribuerService;
import com.reseau.service.IClasseService;
import com.reseau.service.IEtatAmisService;
import com.reseau.service.IPosteService;
import com.reseau.service.IUtilisateurService;

@Controller
public class ProfileController {

	@Autowired
	private IUtilisateurService utilisateurMetier;
	@Autowired
	private IEtatAmisService etatAmisMetier;
	@Autowired
	private IAttribuerService attribuerMetier;
	@Autowired
	private IPosteService posteMetier;
	@Autowired
	private IClasseService classeMetier;
	/*@Autowired
	private ITypeService typeMetier;*/
	
	@RequestMapping("/profile")
	public String profile(Model model){
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		String typeUtilisateur = null;
		String ecoles = null;
		int nbrGroupe = 0;
		List<Classe> groupes = null;
		if(utilisateur instanceof Etudiant){
			ecoles = ((Etudiant) utilisateur).getEcole();
			nbrGroupe = attribuerMetier.nbrGroupe(utilisateur);
			groupes = attribuerMetier.afficherLesGroupes(utilisateur);
		}else if(utilisateur instanceof Professeur){
			ecoles = ((Professeur) utilisateur).getEcoles();
			nbrGroupe = classeMetier.afficherNbeClasses(utilisateur);
			groupes = classeMetier.afficherToutLesClassesParUtilisateur(utilisateur);
		}
		if(utilisateur instanceof Etudiant) typeUtilisateur = "etud";
		else if(utilisateur instanceof Professeur) typeUtilisateur = "prof";
		int nbrAmis = etatAmisMetier.afficherNombreAmisAccepter(utilisateur);
		List<Utilisateur> amis = etatAmisMetier.afficherLesAmis(utilisateur);
		List<Poste> postes = posteMetier.afficherAmisTager(utilisateur);
		Collections.sort(postes,Collections.reverseOrder());
		afficherPostes(postes);
		model.addAttribute("type", typeUtilisateur);
		model.addAttribute("user", utilisateur);
		model.addAttribute("nbrAmis", nbrAmis);
		model.addAttribute("ecole", ecoles);
		model.addAttribute("amis", amis);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		model.addAttribute("postes",postes);
		return "profile";
	}
	
	@RequestMapping(value="/profileChercher", method=RequestMethod.GET)
	public String profileChercher(Model model, String username){
		
		
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		Utilisateur utilisateur2 = utilisateurMetier.afficherUnUtilisateur(username);
		EtatAmis etatAmis = etatAmisMetier.afficherEtatAmis(utilisateur, utilisateur2);
		if(utilisateur2!=null){
			String ecoles = null;
			int nbrGroupe = 0;
			List<Classe> groupes = null;
			if(utilisateur instanceof Etudiant){
				nbrGroupe = attribuerMetier.nbrGroupe(utilisateur);
				groupes = attribuerMetier.afficherLesGroupes(utilisateur);
			}else if(utilisateur instanceof Professeur){
				nbrGroupe = classeMetier.afficherNbeClasses(utilisateur);
				groupes = classeMetier.afficherToutLesClassesParUtilisateur(utilisateur);
			}
			if(utilisateur2 instanceof Etudiant){
				ecoles = ((Etudiant) utilisateur2).getEcole();
			}else if(utilisateur2 instanceof Professeur){
				ecoles = ((Professeur) utilisateur2).getEcoles();
			}
			int nbrAmis = etatAmisMetier.afficherNombreAmisAccepter(utilisateur2);
			int nbrGroupe2 = attribuerMetier.nbrGroupe(utilisateur2);
			List<Poste> postes = posteMetier.afficherAmisTager(utilisateur2);
			Collections.sort(postes,Collections.reverseOrder());
			afficherPostes(postes);
			if(etatAmis!=null && etatAmis.getEtat().equals("accepter")) model.addAttribute("amis", "oui");
			else model.addAttribute("amis", "non");
			model.addAttribute("user", utilisateur);
			model.addAttribute("userSearch", utilisateur2);
			model.addAttribute("ecole", ecoles);
			model.addAttribute("nbrAmis", nbrAmis);
			model.addAttribute("nbrGroupe", nbrGroupe);
			model.addAttribute("nbrGroupe2", nbrGroupe2);
			model.addAttribute("groupes",groupes);
			model.addAttribute("postes",postes);
			return "profileSearch";
		}else{
			return "redirect:/404";
		}
		
	}
	
	/*@RequestMapping(value="/ajouterStatut",method=RequestMethod.POST)
	public String ajouterStatut(Model model, String type, String statut){
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		Type type2 = typeMetier.afficherTypeParNom(type);
		posteMetier.ajouterPoste(statut, new Date(), type2, utilisateur);
		return "redirect:/profile";
	}*/
	
	
	/*private void afficher(List<Utilisateur> utilisateurs){
		for (Utilisateur utilisateur : utilisateurs) {
			System.out.println(utilisateur.getUsername());
		}
	}*/
	
	private void afficherPostes(List<Poste> postes){
		for (Poste poste : postes) {
			System.out.println(poste.getStatut()+" : "+poste.getUtilisateur().getUsername()+" : "+poste.getDate());
		}
	}
}
