package com.kouhou.jee.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

	public Page<Film> findByTitre(String titre,Pageable pageable);

	public Page<Film> findByRealisateur(String realisateur,Pageable pageable);
	
	public Page<Film> findByDuree(double duree,Pageable pageable);
	
	@Query(value = "select * from film f where f.titre:=titre",nativeQuery = true)
	public List<Film> findAllByTitre(String titre);
	
	public Page<Film> findByDateSortie(Date dateSortie,Pageable pageable);
	
	public Film findByPhoto(String photo);
	
	@Query(value = "select (id,titre,realisateur,duree,description,date_sortie,categorie_id)  from film f where f.categorie_id:=categorie",nativeQuery = true)
	public Page<Film> findByCatagorie(String categorie, Pageable pageable);
}
