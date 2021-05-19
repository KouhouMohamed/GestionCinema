package com.kouhou.jee.Service;

import java.util.Date;
import java.util.List;

import com.kouhou.jee.entities.Seance;

public interface SeanceService {

	public List<Seance> findByDate(Date date, int page, int size);
	
	public Seance updateSeance(Long id, Seance senace);
	
	public void deleteSeance(Long id);
	
}
