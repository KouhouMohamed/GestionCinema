package com.kouhou.jee.Service;

import java.util.List;

import com.kouhou.jee.entities.Categorie;

public interface CategorieService {

	public Categorie findCategorie(String name);
	
	public List<Categorie> findAllCategories(int page, int limit);
	
	public Categorie updateCategorie(String name, Categorie categorie);
	
	public Categorie addCategorie(Categorie categorie);
	
	public void deleteCategorie(String name);
}
