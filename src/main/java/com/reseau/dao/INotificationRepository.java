package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.Notification;
import com.reseau.model.Utilisateur;

public interface INotificationRepository extends JpaRepository<Notification, Long> {
	
	@Query("select count(p) from Notification p where p.utilisateur=:x and p.vu=false")
	public int afficherNombreNotificationNonVu(@Param("x")Utilisateur utilisateur);
	
	@Query("select p from Notification p where p.utilisateur=:x and p.vu=false")
	public List<Notification> afficherListeNotificationNonVu(@Param("x")Utilisateur utilisateur);

}
