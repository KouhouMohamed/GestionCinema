<<<<<<< HEAD
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
=======
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
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
