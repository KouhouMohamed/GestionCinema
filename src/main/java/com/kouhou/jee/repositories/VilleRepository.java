package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Ville;

@Repository 
public interface VilleRepository {

	public Ville findById(Long id);
	
	@Query(value="select * from Ville where atitude=:atitude and longitude=:longitude and altiude=:altitude" ,nativeQuery = true)
	public Ville findByPosition(double atitude, double longitude, double altitude);
	
}
