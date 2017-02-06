package com.reseau.service;

import java.util.Date;
import java.util.List;

import com.reseau.model.Notification;
import com.reseau.model.Utilisateur;

public interface INotificationService {
	
	public void ajouterNotification(Date date, String message, String type, Utilisateur utilisateur, Utilisateur utilisateurNotifier);
	public void supprimerNotification(Long idNotification);
	public Notification afficherUneNotification(Long idNotification);
	public List<Notification> afficherToutLesNotificationsNonVu(Utilisateur utilisateur);
	public void changerEtatVu(Long idNotification);
	public int nbrNotifNonVu(Utilisateur utilisateur);

}
