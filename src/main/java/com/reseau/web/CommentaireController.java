package com.reseau.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reseau.model.Classe;
import com.reseau.model.EtatAmis;
import com.reseau.model.Etudiant;
import com.reseau.model.Poste;
import com.reseau.model.Professeur;
import com.reseau.model.Utilisateur;
import com.reseau.service.IAttribuerService;
import com.reseau.service.IClasseService;
import com.reseau.service.ICommenterService;
import com.reseau.service.IEtatAmisService;
import com.reseau.service.IPosteService;
import com.reseau.service.IUtilisateurService;

@Controller
public class CommentaireController {

	@Autowired
	private IUtilisateurService utilisateurMetier;
	@Autowired
	private IEtatAmisService etatAmisMetier;
	@Autowired
	private IAttribuerService attribuerMetier;
	@Autowired
	private IPosteService posteMetier;
	@Autowired
	private ICommenterService commenterMetier;
	@Autowired
	private IClasseService classeMetier;
	
	@RequestMapping("/ajouterCommentaireM")
	public String ajouterCommentaireM(Model model, Long poste, String message){
		Utilisateur user = utilisateurMetier.getConnectedManInfo();
		int nbrGroupe = 0;
		List<Classe> groupes = null;
		if(user instanceof Etudiant){
			nbrGroupe = attribuerMetier.nbrGroupe(user);
			groupes = attribuerMetier.afficherLesGroupes(user);
		}else if(user instanceof Professeur){
			nbrGroupe = classeMetier.afficherNbeClasses(user);
			groupes = classeMetier.afficherToutLesClassesParUtilisateur(user);
		}
		List<Utilisateur> utilisateurs = etatAmisMetier.afficherLesAmis(user);
		List<Poste> postes = posteMetier.afficherPostesAmis(user, utilisateurs);
		Collections.sort(postes,Collections.reverseOrder());
		Poste poste2 = posteMetier.afficherUnPoste(poste);
		commenterMetier.ajouterCommentaire(user, poste2, message);
		model.addAttribute("user", user);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		model.addAttribute("postes",postes);
		return "redirect:/index";
	}
	
	@RequestMapping("/ajouterCommentaireP")
	public String ajouterCommentaireP(Model model, Long poste, String message){
		Utilisateur user = utilisateurMetier.getConnectedManInfo();
		int nbrGroupe = 0;
		List<Classe> groupes = null;
		if(user instanceof Etudiant){
			nbrGroupe = attribuerMetier.nbrGroupe(user);
			groupes = attribuerMetier.afficherLesGroupes(user);
		}else if(user instanceof Professeur){
			nbrGroupe = classeMetier.afficherNbeClasses(user);
			groupes = classeMetier.afficherToutLesClassesParUtilisateur(user);
		}
		List<Utilisateur> utilisateurs = etatAmisMetier.afficherLesAmis(user);
		List<Poste> postes = posteMetier.afficherPostesAmis(user, utilisateurs);
		Collections.sort(postes,Collections.reverseOrder());
		Poste poste2 = posteMetier.afficherUnPoste(poste);
		commenterMetier.ajouterCommentaire(user, poste2, message);
		model.addAttribute("user", user);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		model.addAttribute("postes",postes);
		return "redirect:/profil";
	}
	
	@RequestMapping("/ajouterCommentairePS")
	public String ajouterCommentairePS(Model model, Long poste, String message, String username){

		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		Utilisateur utilisateur2 = utilisateurMetier.afficherUnUtilisateur(username);
		EtatAmis etatAmis = etatAmisMetier.afficherEtatAmis(utilisateur, utilisateur2);
		if(utilisateur2!=null){
			int nbrAmis = etatAmisMetier.afficherNombreAmisAccepter(utilisateur2);
			int nbrGroupe2 = attribuerMetier.nbrGroupe(utilisateur2);
			int nbrGroupe = 0;
			List<Classe> groupes = null;
			if(utilisateur instanceof Etudiant){
				nbrGroupe = attribuerMetier.nbrGroupe(utilisateur);
				groupes = attribuerMetier.afficherLesGroupes(utilisateur);
			}else if(utilisateur instanceof Professeur){
				nbrGroupe = classeMetier.afficherNbeClasses(utilisateur);
				groupes = classeMetier.afficherToutLesClassesParUtilisateur(utilisateur);
			}
			List<Poste> postes = posteMetier.afficherAmisTager(utilisateur2);
			Collections.sort(postes,Collections.reverseOrder());
			Poste poste2 = posteMetier.afficherUnPoste(poste);
			commenterMetier.ajouterCommentaire(utilisateur, poste2, message);
			if(etatAmis!=null && etatAmis.getEtat().equals("accepter")) model.addAttribute("amis", "oui");
			else model.addAttribute("amis", "non");
			model.addAttribute("user", utilisateur);
			model.addAttribute("userSearch", utilisateur2);
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
}
