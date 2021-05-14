package com.kouhou.jee.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Projection;

@Repository
public interface ProjectionRepository {

	public Projection findById(Long id);
	
	public Page<Projection> findBydateProjection(Date dateProjection, Pageable pageable);
	
	
}
