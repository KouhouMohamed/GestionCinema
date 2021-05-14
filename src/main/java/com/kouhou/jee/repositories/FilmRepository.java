package com.kouhou.jee.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Film;

@Repository
public interface FilmRepository {

	public Film findById(Long id);
	
	public Film findByTitre(String titre);
	
	public Page<Film> findByRealisateur(String realisateur,Pageable pageable);
	
	public Page<Film> findByDateSortie(Date dateSortie,Pageable pageable);
	
	public Film findByPhoto(String photo);
}
