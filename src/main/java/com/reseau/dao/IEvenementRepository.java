package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reseau.model.Evenement;

public interface IEvenementRepository extends JpaRepository<Evenement, Long> {

}
