package com.reseau.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.INotificationRepository;
import com.reseau.model.Notification;
import com.reseau.model.Utilisateur;
import com.reseau.service.INotificationService;
@Service
@Transactional
public class NotificationService implements INotificationService {

	@Autowired
	private INotificationRepository notificationRepository;
	
	@Override
	public void ajouterNotification(Date date, String message, Utilisateur utilisateur) {
		Notification notification = new Notification(date, message, utilisateur);
		notificationRepository.save(notification);
	}

	@Override
	public void supprimerNotification(Long idNotification) {
		Notification notification = afficherUneNotification(idNotification);
		notificationRepository.delete(notification);
	}

	@Override
	public Notification afficherUneNotification(Long idNotification) {
		Notification notification = notificationRepository.findOne(idNotification);
		if(notification==null) throw new RuntimeException("Notification introuvable");
		return notification;
	}

	@Override
	public List<Notification> afficherToutLesNotifications() {
		return notificationRepository.findAll();
	}

}
