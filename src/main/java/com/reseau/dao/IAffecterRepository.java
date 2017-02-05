package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reseau.model.Affecter;
import com.reseau.model.AffecterID;

public interface IAffecterRepository extends JpaRepository<Affecter, AffecterID> {

}
