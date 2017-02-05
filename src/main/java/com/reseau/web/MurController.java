package com.reseau.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reseau.model.Classe;
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
public class MurController {
	
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
	
	@RequestMapping("/index")
	public String index(Model model){
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
		
		List<Utilisateur> utilisateurs = etatAmisMetier.afficherLesAmis(utilisateur);
		List<Poste> postes = posteMetier.afficherPostesAmis(utilisateur, utilisateurs);
		Collections.sort(postes,Collections.reverseOrder());
		model.addAttribute("user", utilisateur);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		model.addAttribute("postes",postes);
		return "index";
	}
	
}
