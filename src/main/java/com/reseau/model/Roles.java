package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3018268890547916612L;
	
	@Id
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Roles(String role) {
		super();
		this.role = role;
	}

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
