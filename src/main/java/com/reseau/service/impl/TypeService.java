package com.reseau.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reseau.dao.ITypeRepository;
import com.reseau.model.Type;
import com.reseau.service.ITypeService;

@Service
@Transactional
public class TypeService implements ITypeService{

	@Autowired
	private ITypeRepository typeRepository;
	
	@Override
	public void ajouterType(String message) {
		Type type = new Type(message);
		typeRepository.save(type);
	}

	@Override
	public void modifierType(Long idType, String message) {
		Type type = afficherUnType(idType);
		type.setMessage(message);
		typeRepository.save(type);
	}

	@Override
	public void supprimerType(Long idType) {
		Type type = afficherUnType(idType);
		typeRepository.delete(type);
	}

	@Override
	public Type afficherUnType(Long idType) {
		Type type = typeRepository.findOne(idType);
		if(type==null) throw new RuntimeException("Type introuvable");
		return type;
	}

	@Override
	public List<Type> afficherToutLesTypes() {
		return typeRepository.findAll();
	}

	@Override
	public Type afficherTypeParNom(String nom) {
		Type type = typeRepository.afficherTypeParNom(nom);
			if(type==null) throw new RuntimeException("Type introuvable");
		return type;
	}

}
