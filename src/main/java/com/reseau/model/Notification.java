package com.reseau.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Notification implements Serializable, Comparable<Notification>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5350513499526902081L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNotification;
	private Date date;
	private String message;
	@ManyToOne
	@JoinColumn(name="username")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="usernameNotifier")
	private Utilisateur utilisateurNotifier;
	private boolean vu;
	private String type;

	
	public Notification(Date date, String message, Utilisateur utilisateur, Utilisateur utilisateurNotifier, String type) {
		
		this.date = date;
		this.message = message;
		this.utilisateur = utilisateur;
		this.utilisateurNotifier = utilisateurNotifier;
		this.type = type;
		this.vu = false;
	}

	public boolean isVu() {
		return vu;
	}

	public void setVu(boolean vu) {
		this.vu = vu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Long getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Long idNotification) {
		this.idNotification = idNotification;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Notification o) {
		int cmprDate = this.date.compareTo(o.date);
		if(cmprDate != 0) return cmprDate;
		return 0;
	}

	public Utilisateur getUtilisateurNotifier() {
		return utilisateurNotifier;
	}

	public void setUtilisateurNotifier(Utilisateur utilisateurNotifier) {
		this.utilisateurNotifier = utilisateurNotifier;
	}

	
	

}
