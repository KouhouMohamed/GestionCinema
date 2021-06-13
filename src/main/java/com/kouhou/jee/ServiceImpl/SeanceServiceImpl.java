package com.kouhou.jee.ServiceImpl;

import java.rmi.server.ServerNotActiveException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kouhou.jee.Service.SeanceService;
import com.kouhou.jee.entities.Seance;
import com.kouhou.jee.repositories.SeanceRepository;

@Service
@Transactional
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

	@Override
	public Seance findSeance(Long id) {
		Optional<Seance> seance = seanceRepository.findById(id);
		if(seance ==null)
			throw new EntityNotFoundException("No seance with id "+id+" is founded");
		else
			return seance.get();
	}

	@Override
	public List<Seance> findAll(int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Seance> seances = seanceRepository.findAll(pageable);
		if(seances == null)
			return new ArrayList<Seance>();
		else
			return seances.toList();
	}

}
