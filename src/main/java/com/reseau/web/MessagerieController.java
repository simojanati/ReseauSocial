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
import com.reseau.model.Messagerie;
import com.reseau.model.Notification;
import com.reseau.model.Poste;
import com.reseau.model.Professeur;
import com.reseau.model.Utilisateur;
import com.reseau.service.IAttribuerService;
import com.reseau.service.IClasseService;
import com.reseau.service.IEtatAmisService;
import com.reseau.service.IMessagerieService;
import com.reseau.service.INotificationService;
import com.reseau.service.IPosteService;
import com.reseau.service.IUtilisateurService;

@Controller
public class MessagerieController {
	
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
	@Autowired
	private IMessagerieService messagerieMetier;
	@Autowired
	private INotificationService notificationMetier;
	
	@RequestMapping("/inbox")
	public String inbox(Model model){
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
		int nbrMsg = messagerieMetier.afficherNbrMessageNonVu(utilisateur);
		List<Messagerie> messageriesEnvoyer = messagerieMetier.afficherMessagesEnvoyer(utilisateur);
		Collections.sort(messageriesEnvoyer,Collections.reverseOrder());
		List<Messagerie> messageriesRecu = messagerieMetier.afficherMessagesRecue(utilisateur);
		Collections.sort(messageriesRecu,Collections.reverseOrder());
		List<Utilisateur> utilisateurs = etatAmisMetier.afficherLesAmis(utilisateur);
		List<Poste> postes = posteMetier.afficherPostesAmis(utilisateur, utilisateurs);
		Collections.sort(postes,Collections.reverseOrder());
		List<Notification> notifications = notificationMetier.afficherToutLesNotificationsNonVu(utilisateur);
		Collections.sort(notifications,Collections.reverseOrder());
		int nbrNotif = notificationMetier.nbrNotifNonVu(utilisateur);
		model.addAttribute("notifications", notifications);
		model.addAttribute("nbrNotif", nbrNotif);
		model.addAttribute("user", utilisateur);
		model.addAttribute("msgEnvoyer", messageriesEnvoyer);
		model.addAttribute("msgRecue", messageriesRecu);
		model.addAttribute("nbrMsg", nbrMsg);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		model.addAttribute("postes",postes);
		return "mailbox";
	}
	
	@RequestMapping("/message")
	public String envoisMessage(Model model){
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
		List<Notification> notifications = notificationMetier.afficherToutLesNotificationsNonVu(utilisateur);
		Collections.sort(notifications,Collections.reverseOrder());
		int nbrNotif = notificationMetier.nbrNotifNonVu(utilisateur);
		model.addAttribute("notifications", notifications);
		model.addAttribute("nbrNotif", nbrNotif);
		model.addAttribute("user", utilisateur);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		model.addAttribute("postes",postes);
		return "compose";
	}
	@RequestMapping("/ajouterMessage")
	public String ajouterMessage(String username, String objet, String message){
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		String resultat = null;
		Utilisateur utilisateurRecoie = utilisateurMetier.afficherUnUtilisateur(username);
		if(utilisateurRecoie!=null){
			messagerieMetier.ajouterMessage(message, objet, utilisateur, utilisateurRecoie);
			resultat = "redirect:/inbox";
		}else{
			resultat = "redirect:/404";
		}
		return resultat;
	}

	@RequestMapping(value="/lireMessage", method=RequestMethod.GET)
	public String lireMessage(Model model, String idMessage){
		Utilisateur utilisateur = utilisateurMetier.getConnectedManInfo();
		Messagerie message = messagerieMetier.afficherMessage(Long.parseLong(idMessage));
		messagerieMetier.changerEtatVu(Long.parseLong(idMessage));
		int nbrGroupe = 0;
		List<Classe> groupes = null;
		if(utilisateur instanceof Etudiant){
			nbrGroupe = attribuerMetier.nbrGroupe(utilisateur);
			groupes = attribuerMetier.afficherLesGroupes(utilisateur);
		}else if(utilisateur instanceof Professeur){
			nbrGroupe = classeMetier.afficherNbeClasses(utilisateur);
			groupes = classeMetier.afficherToutLesClassesParUtilisateur(utilisateur);
		}
		int nbrMsg = messagerieMetier.afficherNbrMessageNonVu(utilisateur);
		List<Messagerie> messageriesRecu = messagerieMetier.afficherMessagesRecue(utilisateur);
		Collections.sort(messageriesRecu,Collections.reverseOrder());
		List<Utilisateur> utilisateurs = etatAmisMetier.afficherLesAmis(utilisateur);
		List<Poste> postes = posteMetier.afficherPostesAmis(utilisateur, utilisateurs);
		Collections.sort(postes,Collections.reverseOrder());
		List<Notification> notifications = notificationMetier.afficherToutLesNotificationsNonVu(utilisateur);
		Collections.sort(notifications,Collections.reverseOrder());
		int nbrNotif = notificationMetier.nbrNotifNonVu(utilisateur);
		model.addAttribute("notifications", notifications);
		model.addAttribute("nbrNotif", nbrNotif);
		model.addAttribute("user", utilisateur);
		model.addAttribute("msg", message);
		model.addAttribute("msgRecue", messageriesRecu);
		model.addAttribute("nbrMsg", nbrMsg);
		model.addAttribute("nbrGroupe", nbrGroupe);
		model.addAttribute("groupes",groupes);
		model.addAttribute("postes",postes);
		return "read-mail";
	}
	@RequestMapping(value="/suppMessage", method=RequestMethod.GET)
	public String suppMessage(String idMessage){
		messagerieMetier.supprimerMessage(Long.parseLong(idMessage));
		return "redirect:/inbox";
	}
}
