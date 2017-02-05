package com.reseau.service;

import java.util.Date;
import java.util.List;

import com.reseau.model.Notification;
import com.reseau.model.Utilisateur;

public interface INotificationService {
	
	public void ajouterNotification(Date date, String message, Utilisateur utilisateur);
	public void supprimerNotification(Long idNotification);
	public Notification afficherUneNotification(Long idNotification);
	public List<Notification> afficherToutLesNotifications();

}
