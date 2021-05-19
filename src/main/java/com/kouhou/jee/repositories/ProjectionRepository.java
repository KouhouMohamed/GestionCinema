package com.kouhou.jee.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long>{

	public Page<Projection> findByPrix(double prix, Pageable pageable);
	
	public Page<Projection> findBydateProjection(Date dateProjection, Pageable pageable);
	
	
}
