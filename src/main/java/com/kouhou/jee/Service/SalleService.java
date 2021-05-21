package com.kouhou.jee.Service;

import java.util.List;

import com.kouhou.jee.entities.Salle;

public interface SalleService {
	

	public Salle findSalle(Long id);
	
	public List<Salle> findByNombrePlace(int nombre, int page, int limit);
	
	public Salle upadateSalle(Long numero, Salle salle);
	
	public Salle addSalle(Salle salle);
	
	public void deleteSalle(Long id);

	public List<Salle> findByCinema(Long idCinema, int page, int limit);
	
	public List<Salle> findAll(int page, int limit);
}
