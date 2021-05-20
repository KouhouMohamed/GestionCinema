package com.kouhou.jee.ServiceImpl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kouhou.jee.Service.CategorieService;
import com.kouhou.jee.entities.Categorie;
import com.kouhou.jee.repositories.CategorieRepository;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService{

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public Categorie findCategorie(String name) {
		Categorie cat = categorieRepository.findByName(name);
		if(cat == null)
			throw new EntityNotFoundException("No Category with name "+name+" not found");
		else
			return cat;
	}

	@Override
	public Categorie updateCategorie(String name, Categorie categorie) {
		Categorie cat = categorieRepository.findByName(name);
		if(cat == null)
			throw new EntityNotFoundException("No Category with name "+name+" not found");
		else {
			categorie.setId(cat.getId());
			categorieRepository.save(categorie);
			return categorie;
		}
		
	}

	@Override
	public Categorie addCategorie(Categorie categorie)  {
		Categorie cat = categorieRepository.findByName(categorie.getName());
		if(cat != null)
			throw new EntityExistsException("a category with name "+categorie.getName()+" already exist");
		else {
			categorieRepository.save(categorie);
			return categorie;
		}
	}

	@Override
	public void deleteCategorie(String name) {
		Categorie cat = categorieRepository.findByName(name);
		if(cat == null)
			throw new EntityNotFoundException("No Category with name "+name+" not found");
		else
			categorieRepository.delete(cat);
		
	}

	@Override
	public List<Categorie> findAllCategories(int page, int limit) {
		
		Pageable pageable = PageRequest.of(page, limit);
		List<Categorie> cats = categorieRepository.findAllCategories(pageable).toList();
		return cats;
	}

}
