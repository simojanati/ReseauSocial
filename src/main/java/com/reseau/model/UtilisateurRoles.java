package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UtilisateurRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2756902399385085329L;
	
	@Id
	private UtilisateurRolesId id;

	public UtilisateurRolesId getId() {
		return id;
	}

	public void setId(UtilisateurRolesId id) {
		this.id = id;
	}
	
	public Utilisateur getUtilisateur(){
		return getId().getUtilisateur();
	}
	
	public Roles getRoles(){
		return getId().getRoles();
	}
	
	public void setUtilisateur(Utilisateur utilisateur){
		getId().setUtilisateur(utilisateur);
	}
	
	public void setRoles(Roles roles){
		getId().setRoles(roles);
	}

	public UtilisateurRoles(UtilisateurRolesId id) {
		super();
		this.id = id;
	}

	public UtilisateurRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
