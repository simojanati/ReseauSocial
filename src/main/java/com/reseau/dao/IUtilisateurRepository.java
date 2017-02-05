package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reseau.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, String> {

}
