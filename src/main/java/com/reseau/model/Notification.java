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
public class Notification implements Serializable{

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
	
	public Notification(Date date, String message, Utilisateur utilisateur) {
		
		this.date = date;
		this.message = message;
		this.utilisateur = utilisateur;
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

	
	

}
