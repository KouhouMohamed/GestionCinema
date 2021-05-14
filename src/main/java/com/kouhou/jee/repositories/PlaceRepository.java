package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.Query;

import com.kouhou.jee.entities.Place;

public interface PlaceRepository {

	public Place findById(Long id);
	
	public Place findByNumero(int numero);
	
	@Query(value="select * from Cinema where atitude=:atitude and longitude=:longitude and altiude=:altitude" ,nativeQuery = true)
	public Place findByPosition(double atititude, double longitude, double altitude);
}
