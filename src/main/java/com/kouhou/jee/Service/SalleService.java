package com.kouhou.jee.Service;

import java.util.List;

import com.kouhou.jee.entities.Salle;

public interface SalleService {

	public Salle findSalle(String name);
	
	public List<Salle> findByNombrePlace(int nombre, int page, int limit);
	
	public Salle upadateSalle(Long numero, Salle salle);
	
	public void deleteSalle(Long id);

	public List<Salle> findByCinema(Long idCinema, int page, int limit);
}
