package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
	
	public Place findByNumero(int numero);
	
	@Query(value="select * from Cinema where atitude=:atitude and longitude=:longitude and altiude=:altitude" ,nativeQuery = true)
	public Place findByPosition(double atititude, double longitude, double altitude);
}
