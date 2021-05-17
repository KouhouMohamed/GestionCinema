package com.kouhou.jee.Service;

import com.kouhou.jee.entities.Categorie;

public interface CategorieService {

	public Categorie findCategorie(String name);
	
	public Categorie updateCategorie(String name, Categorie categorie);
	
	public Categorie addCategorie(Categorie categorie);
	
	public void deleteCategorie(String name);
}
