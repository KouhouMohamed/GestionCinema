package com.kouhou.jee.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kouhou.jee.Service.SalleService;
import com.kouhou.jee.entities.Salle;
import com.kouhou.jee.repositories.SalleRepository;

@Service
@Transactional
public class SalleServiceImpl implements SalleService {

	@Autowired
	SalleRepository salleRepository;
	
	@Override
	public Salle findSalle(Long id) {
		Optional<Salle> salle = salleRepository.findById(id);
		if(salle == null)
			throw new EntityNotFoundException("No salle with id "+id+" is founded");
		else
			return salle.get();
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

	@Override
	public Salle addSalle(Salle salle) {
		List<Salle> salles = salleRepository.findByCinema(salle.getCinema().getId());
		boolean exist = false;
		for(Salle s : salles) {
			if(s.getNom().equals(salle.getNom())) {
				exist =true;
				break;
			}
		}
		if (exist)
			throw new EntityExistsException();
		else {
			salleRepository.save(salle);
			return salle;
		}
			
	}

	@Override
	public List<Salle> findAll(int page, int limit) {
		Pageable pageable = PageRequest.of(page,limit);
		Page<Salle> salles = salleRepository.findAll(pageable);
		return (salles==null)?new ArrayList<Salle>():salles.toList();
	}

}
