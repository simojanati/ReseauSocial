package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reseau.model.UtilisateurRoles;
import com.reseau.model.UtilisateurRolesId;

public interface IUtilisateurRolesRepository extends JpaRepository<UtilisateurRoles, UtilisateurRolesId>{

}
