package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reseau.model.Roles;

public interface IRolesRepository extends JpaRepository<Roles, String> {

}
