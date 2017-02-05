package com.reseau.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attribuer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 947690502176945810L;
	
	@Id
	private AttribuerID attribuerID;
	private Date dateAttribution;
	
	public AttribuerID getAttribuerID() {
		return attribuerID;
	}
	public void setAttribuerID(AttribuerID attribuerID) {
		this.attribuerID = attribuerID;
	}
	public Date getDateAttribution() {
		return dateAttribution;
	}
	public void setDateAttribution(Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}
	
	public Utilisateur getEtudiant(){
		return getAttribuerID().getIdEtudiant();
	}
	
	public Classe getClasse(){
		return getAttribuerID().getIdClasse();
	}
	
	public void setEtudiant(Etudiant etudiant){
		getAttribuerID().setIdEtudiant(etudiant);
	}
	
	public void setClasse(Classe classe){
		getAttribuerID().setIdClasse(classe);
	}
	
	public Attribuer(AttribuerID attribuerID, Date dateAttribution) {
		super();
		this.attribuerID = attribuerID;
		this.dateAttribution = dateAttribution;
	}
	public Attribuer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
