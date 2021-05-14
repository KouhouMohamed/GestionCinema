package com.kouhou.jee.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kouhou.jee.entities.Seance;

public interface SeanceRepository {

	public Seance findById(Long id);
	
	public Page<Seance> findByDateDebut(Date dateDebut, Pageable pageable);
}
