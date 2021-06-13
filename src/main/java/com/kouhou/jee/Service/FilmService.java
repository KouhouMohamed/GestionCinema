package com.kouhou.jee.Service;

import java.util.Date;
import java.util.List;

import com.kouhou.jee.entities.Film;

public interface FilmService {

	public Film findFilm(Long id);
	
	public List<Film> findByTitel(String titre, int page, int limit);
	
	public List<Film> findByRealisateur(String realisateur, int page, int limit);
	
	public List<Film> findByDuree(double duree, int page, int limit);
	
	public List<Film> findByDate(Date dateSortie, int page, int limit);
	
	public Film addFilm(Film film);
	
	public Film updateFilm(Long id, Film film);
	
	public void deleteFilm(Long id);

	public List<Film> findAll(int page, int limit);
}
