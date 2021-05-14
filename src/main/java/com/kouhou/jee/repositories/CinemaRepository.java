package com.kouhou.jee.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Cinema;

@Repository
public interface CinemaRepository {

	public Cinema findById(Long id);
	
	public Cinema findByNom(String nom);
	
	@Query(value="select * from Cinema c where c.ville.nom=:villeNom" ,nativeQuery = true)
	public Cinema findByVille(String villeNom);
	
	@Query(value="select * from Cinema where atitude=:atitude and longitude=:longitude and altiude=:altitude" ,nativeQuery = true)
	public Cinema findByPosition(double atitude, double longitude, double altitude);
	
	public Page<Cinema> findByNombreSalles(int nombreSalles, Pageable pageable);
	
	
}
