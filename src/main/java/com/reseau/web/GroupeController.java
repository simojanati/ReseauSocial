package com.reseau.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reseau.model.Classe;
import com.reseau.model.Etudiant;
import com.reseau.model.Poste;
import com.reseau.model.Professeur;
import com.reseau.model.Utilisateur;
import com.reseau.service.IAttribuerService;
import com.reseau.service.IClasseService;
import com.reseau.service.ICommenterService;
import com.reseau.service.IPosteService;
import com.reseau.service.IRelationService;
import com.reseau.service.IUtilisateurService;

@Controller
public class GroupeController {

	@Autowired
	private IUtilisateurService utilisateurMetier;
	@Autowired
	private IClasseService classeMetier;
	@Autowired
	private IAttribuerService attribuerMetier;
	@Autowired
	private IRelationService relationMetier;
	@Autowired
	private IPosteService posteMetier;
	@Autowired
	private ICommenterService commenterMetier;
	/*@Autowired
	private ITypeService typeMetier;*/
	
	@RequestMapping(value="/groupe", method=RequestMethod.GET)
	public String profile(Model model, Long idGroupe){
		
		Classe classe = classeMetier.afficherUneClasseParId(idGroupe);
		List<Poste> postes = relationMetier.afficherPostesParClasse(classe);
		Collections.sort(postes,Collections.reverseOrder());
		afficherPostes(postes);
		int nbrEtudiants = attribuerMetier.nbrEtudiant(classe);
		List<Etudiant> etudiants = attribuerMetier.afficherLesEtudiants(classe);
		model = user(model);
		model.addAttribute("groupe", classe);
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("postes", postes);
		model.addAttribute("nbrEtudiants", nbrEtudiants);
		return "groupe";
	}
	
	@RequestMapping("/ajouterCommentaireG")
	public String ajouterCommentaireG(Model model, Long poste, String message, Long idGroupe){
		Classe classe = classeMetier.afficherUneClasseParId(idGroupe);
		List<Poste> postes = relationMetier.afficherPostesParClasse(classe);
		Collections.sort(postes,Collections.reverseOrder());
		Poste poste2 = posteMetier.afficherUnPoste(poste);
		int nbrEtudiants = attribuerMetier.nbrEtudiant(classe);
		List<Etudiant> etudiants = attribuerMetier.afficherLesEtudiants(classe);
		model = user2(model, poste2, message);
		model.addAttribute("groupe", classe);
		model.addAttribute("etudiants", etudiants);
		model.addAttribute("postes", postes);
		model.addAttribute("nbrEtudiants", nbrEtudiants);
		return "groupe";
		
	}
	
	private Model user(Model model){
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		int nbrGroupe = 0;
		List<Classe> groupes = null;
		if(utilisateur instanceof Etudiant){
			nbrGroupe = attribuerMetier.nbrGroupe(utilisateur);
			groupes = attribuerMetier.afficherLesGroupes(utilisateur);
		}else if(utilisateur instanceof Professeur){
			nbrGroupe = classeMetier.afficherNbeClasses(utilisateur);
			groupes = classeMetier.afficherToutLesClassesParUtilisateur(utilisateur);
		}
		model.addAttribute("user", utilisateur);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		return model;
	}
	
	private Model user2(Model model, Poste poste,String message){
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		int nbrGroupe = 0;
		List<Classe> groupes = null;
		if(utilisateur instanceof Etudiant){
			nbrGroupe = attribuerMetier.nbrGroupe(utilisateur);
			groupes = attribuerMetier.afficherLesGroupes(utilisateur);
		}else if(utilisateur instanceof Professeur){
			nbrGroupe = classeMetier.afficherNbeClasses(utilisateur);
			groupes = classeMetier.afficherToutLesClassesParUtilisateur(utilisateur);
		}
		commenterMetier.ajouterCommentaire(utilisateur, poste, message);
		model.addAttribute("user", utilisateur);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		return model;
	}
	
	private void afficherPostes(List<Poste> postes){
		System.out.println("---------------------------------------- DEBUT ---------------------------------------");
		for (Poste poste : postes) {
			System.out.println(poste.getStatut()+" : "+poste.getUtilisateur().getUsername()+" : "+poste.getDate());
		}
		System.out.println("---------------------------------------- FIN -----------------------------------------");
	}
}
