package com.reseau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.Classe;
import com.reseau.model.Poste;
import com.reseau.model.Relation;
import com.reseau.model.RelationID;

public interface IRelationRepository extends JpaRepository<Relation, RelationID> {

	@Query("select r.RelationID.poste from Relation r where r.RelationID.Classe=:x")
	public List<Poste> afficherPostes(@Param("x")Classe classe);
}
