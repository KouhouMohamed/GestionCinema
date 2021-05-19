package com.kouhou.jee.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	public Categorie findByName(String name);
	
	@Query(value = "select * from categorie", nativeQuery = true)
	public Page<Categorie> findAllCategories(Pageable pageable);
	
}
