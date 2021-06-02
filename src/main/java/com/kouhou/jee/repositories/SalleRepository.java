package com.kouhou.jee.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long>{
	
	public Salle findByNom(String nom);
	
	@Query(value = "select * from salle s where s.cinema_id=:idCinema",nativeQuery = true)
	public Page<Salle> findByCinema(Long idCinema, Pageable pageable);
	
	@Query(value = "select * from salle s where s.cinema_id=:idCinema",nativeQuery = true)
	public List<Salle> findByCinema(Long idCinema);
	
	
	public Page<Salle> findByNombrePlaces(int nombrePlaces, Pageable pageable);
	
	
}
