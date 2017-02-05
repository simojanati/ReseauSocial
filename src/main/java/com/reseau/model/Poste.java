package com.reseau.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Poste implements Serializable, Comparable<Poste>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7326484399000138692L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPoste;
	private String statut;
	private Date date;
	private String lien;
	private String nomLien;
	@ManyToOne
	@JoinColumn(name="idType")
	private Type type;
	
	@ManyToOne
	@JoinColumn(name="username")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="username_tage")
	private Utilisateur utilisateurTager;
	@Column(columnDefinition="boolean default false")
	private boolean groupe = false;
	
	@OneToMany
	@JoinColumn(name="idPoste",referencedColumnName="idPoste")
	private List<Commenter> commenters;
	
	
	public List<Commenter> getCommenters() {
		Collections.sort(commenters);
		return commenters;
	}

	public void setCommenters(List<Commenter> commenters) {
		this.commenters = commenters;
	}

	public boolean isGroupe() {
		return groupe;
	}

	public void setGroupe(boolean groupe) {
		this.groupe = groupe;
	}

	public Poste(String statut, Date date, Type type, String lien, String nomLien, boolean groupe) {
		
		this.statut = statut;
		this.date = date;
		this.type = type;
		this.lien = lien;
		this.nomLien = nomLien;
		this.groupe = groupe;
	}

	public String getNomLien() {
		return nomLien;
	}

	public void setNomLien(String nomLien) {
		this.nomLien = nomLien;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Long getIdPoste() {
		return idPoste;
	}

	public void setIdPoste(Long idPoste) {
		this.idPoste = idPoste;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateurTager() {
		return utilisateurTager;
	}

	public void setUtilisateurTager(Utilisateur utilisateurTager) {
		this.utilisateurTager = utilisateurTager;
	}

	public Poste() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Poste o) {
		int cmprDate = this.getDate().compareTo(o.getDate());
		if(cmprDate != 0) return cmprDate; 
		return 0;
	}
	
}
