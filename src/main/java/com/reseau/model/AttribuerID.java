package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AttribuerID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9154848084556679841L;
	
	@ManyToOne
	@JoinColumn(name="idEtudiant",referencedColumnName="username")
	private Etudiant idEtudiant;
	@ManyToOne
	@JoinColumn(name="idClasse",referencedColumnName="idClasse")
	private Classe idClasse;
	

	public Etudiant getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Etudiant idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public Classe getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Classe idClasse) {
		this.idClasse = idClasse;
	}

	public AttribuerID(Etudiant idEtudiant, Classe idClasse) {
		super();
		this.idEtudiant = idEtudiant;
		this.idClasse = idClasse;
	}

	public AttribuerID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
