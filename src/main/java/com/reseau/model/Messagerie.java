package com.reseau.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
@Entity
public class Messagerie implements Serializable,Comparable<Messagerie>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4319186587839765045L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMesagerie;
	private Date date;
	@Lob
	private String message;
	private String objet;
	@ManyToOne
	@JoinColumn(name="usernameUtilisateurEnvoie")
	private Utilisateur utilisateurEnvoie;
	@ManyToOne
	@JoinColumn(name="usernameUtilisateurRecoie")
	private Utilisateur utilisateurRecoie;
	@Column(columnDefinition="boolean default false")
	private boolean vu;
	
	
	
	public Messagerie(Date date, String message, String objet, Utilisateur utilisateurEnvoie, Utilisateur utilisateurRecoie,
			boolean vu) {
		super();
		this.date = date;
		this.message = message;
		this.objet = objet;
		this.utilisateurEnvoie = utilisateurEnvoie;
		this.utilisateurRecoie = utilisateurRecoie;
		this.vu = vu;
	}

	public Messagerie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Utilisateur getUtilisateurEnvoie() {
		return utilisateurEnvoie;
	}

	public void setUtilisateurEnvoie(Utilisateur utilisateurEnvoie) {
		this.utilisateurEnvoie = utilisateurEnvoie;
	}

	public Utilisateur getUtilisateurRecoie() {
		return utilisateurRecoie;
	}

	public void setUtilisateurRecoie(Utilisateur utilisateurRecoie) {
		this.utilisateurRecoie = utilisateurRecoie;
	}

	public boolean isVu() {
		return vu;
	}

	public void setVu(boolean vu) {
		this.vu = vu;
	}

	public Long getIdMesagerie() {
		return idMesagerie;
	}

	public void setIdMesagerie(Long idMesagerie) {
		this.idMesagerie = idMesagerie;
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

	@Override
	public int compareTo(Messagerie o) {
		int cmprDate = this.date.compareTo(o.date);
		if(cmprDate != 0) return cmprDate;
		return 0;
	}
	
	
	

}
