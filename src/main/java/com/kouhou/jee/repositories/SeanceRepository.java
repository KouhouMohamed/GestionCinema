package com.kouhou.jee.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long>{

	
	public Page<Seance> findByDateDebut(Date dateDebut, Pageable pageable);
}
