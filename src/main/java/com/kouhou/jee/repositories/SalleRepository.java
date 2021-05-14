package com.kouhou.jee.repositories;

import org.springframework.data.domain.Page;

import com.kouhou.jee.entities.Salle;

public interface SalleRepository {

	public Salle findByNumero(Long numero);
	
	public Page<Salle> findByNombrePlaces(int nombrePlaces);
	
}
