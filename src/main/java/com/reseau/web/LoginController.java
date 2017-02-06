package com.reseau.web;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reseau.model.Classe;
import com.reseau.model.Notification;
import com.reseau.model.Utilisateur;
import com.reseau.service.IAttribuerService;
import com.reseau.service.IMessagerieService;
import com.reseau.service.INotificationService;
import com.reseau.service.IUtilisateurService;

@Controller
public class LoginController {

	@Autowired
	private IUtilisateurService utilisateurMetier;
	@Autowired
	private IAttribuerService attribuerMetier;
	@Autowired
	private IMessagerieService messagerieMetier;
	@Autowired
	private INotificationService notificationMetier;
	
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
		int nbrMsg = messagerieMetier.afficherNbrMessageNonVu(utilisateur);
		List<Notification> notifications = notificationMetier.afficherToutLesNotificationsNonVu(utilisateur);
		Collections.sort(notifications,Collections.reverseOrder());
		int nbrNotif = notificationMetier.nbrNotifNonVu(utilisateur);
		model.addAttribute("notifications", notifications);
		model.addAttribute("nbrNotif", nbrNotif);
		model.addAttribute("nbrMsg", nbrMsg);
		model.addAttribute("user", utilisateur);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		return model;
	}
}
