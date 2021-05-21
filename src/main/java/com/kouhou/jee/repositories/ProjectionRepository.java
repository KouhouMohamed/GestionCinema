package com.kouhou.jee.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long>{

	public Page<Projection> findByPrix(double prix, Pageable pageable);
	
	public Page<Projection> findBydateProjection(Date dateProjection, Pageable pageable);
	
	@Query(value = "select * from projection p where p.date_projection:=date and p.film_id:=id_film and p.salle_id:=id_salle",nativeQuery = true)
	public List<Projection> findByDateAndSalle(Date date, Long id_salle, Long id_film);
}
