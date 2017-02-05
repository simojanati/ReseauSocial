package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reseau.model.Messagerie;

public interface IMessagerieRepository extends JpaRepository<Messagerie, Long> {

}
