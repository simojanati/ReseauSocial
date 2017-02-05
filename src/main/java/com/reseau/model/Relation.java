package com.reseau.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Relation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5944623929010463934L;

	@Id
	private RelationID RelationID;
	

	public Relation(RelationID relationID) {
		super();
		this.RelationID = relationID;
	}
	
	public RelationID getRelationID() {
		return RelationID;
	}

	public void setRelationID(RelationID relationID) {
		RelationID = relationID;
	}

	public Relation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
