<<<<<<< HEAD
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
=======
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
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
