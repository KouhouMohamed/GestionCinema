package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Ville;

@Repository 
public interface VilleRepository extends JpaRepository<Ville, Long>{

	
	@Query(value="select * from Ville where atitude=:atitude and longitude=:longitude and altitude=:altitude" ,nativeQuery = true)
	public Ville findByPosition(double atitude, double longitude, double altitude);
	
	public Ville findByNom(String nom);
	
}
