package com.kouhou.jee.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kouhou.jee.Service.SeanceService;
import com.kouhou.jee.entities.Seance;
import com.kouhou.jee.repositories.SeanceRepository;

public class SeanceServiceImpl implements SeanceService {

	@Autowired
	SeanceRepository seanceRepository;
	
	@Override
	public List<Seance> findByDate(Date date,int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Seance> seances = seanceRepository.findByDateDebut(date, pageable);
		if(seances == null)
			return new ArrayList<Seance>();
		else
			return seances.toList();
	}

	@Override
	public Seance updateSeance(Long id, Seance seance) {
		Optional<Seance> seanceR = seanceRepository.findById(id);
		if(seanceR == null)
			throw new EntityNotFoundException("Seance not found");
		else {
			seance.setId(id);
			seanceRepository.save(seance);
			return seance;
		}
	}

	@Override
	public void deleteSeance(Long id) {
		Optional<Seance> seanceR = seanceRepository.findById(id);
		if(seanceR == null)
			throw new EntityNotFoundException("Seance not found");
		else
			seanceRepository.delete(seanceR.get());
	}

}
