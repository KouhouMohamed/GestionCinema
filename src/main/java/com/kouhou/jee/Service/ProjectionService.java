package com.kouhou.jee.Service;

import java.util.Date;
import java.util.List;

import com.kouhou.jee.entities.Projection;

public interface ProjectionService {

	public Projection findProjection(Long id);
	
	public List<Projection> findByPrice(double prix, int page, int size);
	
	public List<Projection> findBydate(Date date, int page, int size);
	
	public Projection updateProjection(Long id, Projection projection);
	
	public void deleteProjection(Long id);

	public List<Projection> findProjectionsByDate(Date date, Long id_salle,Long id_film);
}
