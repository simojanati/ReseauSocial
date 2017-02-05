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
public class Commenter implements Serializable,Comparable<Commenter>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5065000805619418955L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommentaire;
	private String Message;
	private Date date;
	@ManyToOne
	@JoinColumn(name="idPoste")
	private Poste poste;
	@ManyToOne
	@JoinColumn(name="username")
	private Utilisateur utilisateur;
	
	public String getMessage() {
		return Message;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public Long getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Commenter(String message) {
		super();
		this.Message = message;
		this.date = new Date();
	}

	public Commenter() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Commenter o) {
		int cpt = this.getDate().compareTo(o.getDate());
		if(cpt != 0) return cpt; 
		return 0;
	}

	
	
	

}
