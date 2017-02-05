package com.reseau.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reseau.model.Classe;
import com.reseau.model.Utilisateur;
import com.reseau.service.IAttribuerService;
import com.reseau.service.IUtilisateurService;

@Controller
public class LoginController {

	@Autowired
	private IUtilisateurService utilisateurMetier;
	@Autowired
	private IAttribuerService attribuerMetier;
	
	@RequestMapping("/login")
	public String index(){
		return "login";
	}
	@RequestMapping("/")
	public String profile(){
		return "redirect:/profile";
	}
	@RequestMapping("/403")
	public String error403(Model model){
		model = user(model);
		return "403";
	}
	@RequestMapping("/404")
	public String error404(Model model){
		model = user(model);
		return "404";
	}
	
	private Model user(Model model){
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		int nbrGroupe = attribuerMetier.nbrGroupe(utilisateur);
		List<Classe> groupes = attribuerMetier.afficherLesGroupes(utilisateur);
		model.addAttribute("user", utilisateur);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		return model;
	}
}
