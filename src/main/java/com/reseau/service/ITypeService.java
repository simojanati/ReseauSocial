package com.reseau.service;

import java.util.List;

import com.reseau.model.Type;

public interface ITypeService {
	
	public void ajouterType(String message);
	public void modifierType(Long idType, String message);
	public void supprimerType(Long idType);
	public Type afficherUnType(Long idType);
	public List<Type> afficherToutLesTypes();
	public Type afficherTypeParNom(String nom);

}
