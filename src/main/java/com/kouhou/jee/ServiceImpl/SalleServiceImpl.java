package com.kouhou.jee.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kouhou.jee.Service.SalleService;
import com.kouhou.jee.entities.Salle;
import com.kouhou.jee.repositories.SalleRepository;

public class SalleServiceImpl implements SalleService {

	@Autowired
	SalleRepository salleRepository;
	
	@Override
	public Salle findSalle(String name) {
		Salle salle = salleRepository.findByNom(name);
		if(salle == null)
			throw new EntityNotFoundException("No salle with name "+name+" is founded");
		else
			return salle;
	}

	@Override
	public List<Salle> findByNombrePlace(int nombre, int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Salle> salles = salleRepository.findByNombrePlaces(nombre, pageable);
		if(salles == null)
			return new ArrayList<Salle>();
		else
			return salles.toList();
	}

	@Override
	public Salle upadateSalle(Long numero, Salle salle) {
		Optional<Salle> salleR = salleRepository.findById(numero);
		if(salleR == null)
			throw new EntityNotFoundException("No salle with id "+numero+" found");
		else {
			salle.setId(numero);
			salleRepository.save(salle);
			return salle;
		}
	}

	@Override
	public void deleteSalle(Long id) {
		Optional<Salle> salleR = salleRepository.findById(id);
		if(salleR == null)
			throw new EntityNotFoundException("No salle with id "+id+" found");
		
		else
			salleRepository.delete(salleR.get());
	}

	@Override
	public List<Salle> findByCinema(Long idCinema, int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		Page<Salle> salles = salleRepository.findByCinema(idCinema, pageable);
		if(salles == null)
			return new ArrayList<Salle>();
		else
			return salles.toList();
	}

}
