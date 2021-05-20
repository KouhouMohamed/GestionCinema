package com.kouhou.jee.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
	
	public Place findByNumero(int numero);
	
	@Query(value="select * from Cinema where atitude=:atitude and longitude=:longitude and altiude=:altitude" ,nativeQuery = true)
	public Place findByPosition(double atitude, double longitude, double altitude);
	
	@Query(value = "select * from place p where p.salle_id := salle_id")
	public List<Place> findBySalle(Long salle_id); 
	
	@Query(value = "select * from place p where p.salle_id := salle_id")
	public Page<Place> findBySalle(Long salle_id,Pageable pageable); 
}
