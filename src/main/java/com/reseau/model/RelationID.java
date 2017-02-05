package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RelationID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3880582717791543838L;
	@ManyToOne
	@JoinColumn(name="idClasse",referencedColumnName="idClasse")
	private Classe Classe;
	
	@ManyToOne
	@JoinColumn(name="idPoste",referencedColumnName="idPoste")
	private Poste poste;

	public RelationID(Classe classe, Poste poste) {
		super();
		Classe = classe;
		this.poste = poste;
	}

	public Classe getClasse() {
		return Classe;
	}

	public void setClasse(Classe classe) {
		Classe = classe;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public RelationID() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
