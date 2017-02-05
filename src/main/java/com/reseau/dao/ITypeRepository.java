package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reseau.model.Type;

public interface ITypeRepository extends JpaRepository<Type, Long> {

	@Query("select t from Type t where t.message=:x")
	public Type afficherTypeParNom(@Param("x")String nom);
}
