package com.kouhou.jee.repositories;

import com.kouhou.jee.entities.Categorie;

public interface CategorieRepository {

	public Categorie findByName(String name);
	
	public Categorie findById(Long Id);
	
}
