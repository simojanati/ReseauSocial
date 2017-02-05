package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class UtilisateurRolesId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1368173420435110686L;
	
	@ManyToOne
	@JoinColumn(name="username",referencedColumnName="username")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="role",referencedColumnName="role")
	private Roles roles;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public UtilisateurRolesId(Utilisateur utilisateur, Roles roles) {
		super();
		this.utilisateur = utilisateur;
		this.roles = roles;
	}

	public UtilisateurRolesId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
