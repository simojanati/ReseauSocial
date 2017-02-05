package com.reseau.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeUtilisateur",discriminatorType=DiscriminatorType.STRING,length=20)
public abstract class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5351280137018617115L;
	@Id
	private String username;
	private String nom;
	private String prenom;
	private String password;
	private boolean active;
	private Date dateNaissance;
	private String tel;
	private String adresse;
	private String photo;
	private String pays;
	private String branche;
	private String ville;
	private String fonction;
	private java.sql.Date dateCreation;
	@OneToMany
	@JoinColumn(name="usernameUtilisateurEnvoie",referencedColumnName="username")
	private List<Messagerie> messageriesEnvoie;
	
	@OneToMany
	@JoinColumn(name="usernameUtilisateurRecoie",referencedColumnName="username")
	private List<Messagerie> messageriesRecoie;
	@OneToMany
	@JoinColumn(name="usernameUtilisateur",referencedColumnName="username")
	private List<Notification> notifications;
	@OneToMany
	@JoinColumn(name="username",referencedColumnName="username")
	private List<Commenter> commenters;
	
	@OneToMany
	@JoinColumn(name="username",referencedColumnName="username")
	private List<Poste> postes;
	
	@OneToMany(mappedBy="id.utilisateur")
	private List<Affecter> competences;
	
	
	public String getBranche() {
		return branche;
	}

	public void setBranche(String branche) {
		this.branche = branche;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public List<Affecter> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Affecter> competences) {
		this.competences = competences;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public java.sql.Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(java.sql.Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Utilisateur(String nom, String prenom, String username, String password, Date dateNaissance, String tel,
			String adresse, String photo,String pays,String ville,String branche, boolean active, String fonction, java.sql.Date dateCreation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
		this.adresse = adresse;
		this.photo = photo;
		this.pays=pays;
		this.ville=ville;
		this.branche=branche;
		this.active=active;
		this.fonction=fonction;
		this.dateCreation=dateCreation;
	}

	public List<Messagerie> getMessageriesEnvoie() {
		return messageriesEnvoie;
	}

	public void setMessageriesEnvoie(List<Messagerie> messageriesEnvoie) {
		this.messageriesEnvoie = messageriesEnvoie;
	}

	public List<Messagerie> getMessageriesRecoie() {
		return messageriesRecoie;
	}

	public void setMessageriesRecoie(List<Messagerie> messageriesRecoie) {
		this.messageriesRecoie = messageriesRecoie;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Poste> getPostes() {
		return postes;
	}

	public void setPostes(List<Poste> postes) {
		this.postes = postes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Commenter> getCommenters() {
		return commenters;
	}

	public void setCommenters(List<Commenter> commenters) {
		this.commenters = commenters;
	}

	
	
	
	
	
	
}
