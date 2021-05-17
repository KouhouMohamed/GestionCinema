package com.kouhou.jee.Service;

import java.util.List;

import com.kouhou.jee.entities.Cinema;

public interface CinemaService {

	public Cinema findCinema(String nom);
	
	public Cinema findByPosition(double atitude, double longitude, double altitude);
	
	public List<Cinema> findByVille(String nameVille, int page, int limit);
	
	public List<Cinema> findByNombrePlace(int nombrePlace, int page, int limit);
	
	public Cinema updateCinema(Long id, Cinema cinema);
	
	public void deleteCinema(Long id);
	
}
