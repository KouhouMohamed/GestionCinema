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

import com.kouhou.jee.Service.CinemaService;
import com.kouhou.jee.Service.SalleService;
import com.kouhou.jee.entities.Cinema;
import com.kouhou.jee.entities.Salle;
import com.kouhou.jee.repositories.CinemaRepository;
import com.kouhou.jee.repositories.SalleRepository;

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	SalleRepository salleRepository;
	
	
	@Override
	public Cinema findCinema(String nom) {
		Cinema cinema = cinemaRepository.findByNom(nom);
		if (cinema == null)
			throw new EntityNotFoundException("No cinema with name "+nom+" founded");
		
		else
			return cinema;
	}

	@Override
	public Cinema findByPosition(double atitude, double longitude, double altitude) {
		Cinema cinema = cinemaRepository.findByPosition(atitude, longitude, altitude);
		if (cinema == null)
			throw new EntityNotFoundException("No cinema in ("+atitude+","+longitude+","+altitude+") founded");
		
		else
			return cinema;
	}

	@Override
	public List<Cinema> findByVille(String nameVille, int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		List<Cinema> cinemas;
		if(cinemaRepository.findByVille(nameVille,pageable) != null)
			cinemas = cinemaRepository.findByVille(nameVille,pageable).toList();
		else
			cinemas = new ArrayList<Cinema>();
		return cinemas;
	}

	@Override
	public List<Cinema> findByNombreSalles(int nombreSalles, int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		List<Cinema> cinemas;
		if(cinemaRepository.findByNombreSalles(nombreSalles,pageable) != null)
			cinemas = cinemaRepository.findByNombreSalles(nombreSalles,pageable).toList();
		else
			cinemas = new ArrayList<Cinema>();
		return cinemas;
	}

	@Override
	public Cinema updateCinema(Long id, Cinema cinema) {
		Optional<Cinema> cinemaResult = cinemaRepository.findById(id);
		if(cinemaResult == null)
			throw new EntityNotFoundException("No cinema with id "+id+" founded");
		else {
			cinema.setId(id);
			cinemaRepository.save(cinema);
			return cinema;
		}
	}

	@Override
	public void deleteCinema(Long id) {
		Optional<Cinema> cinema = cinemaRepository.findById(id);
		
		if(cinema == null)
			throw new EntityNotFoundException("No cinema with id "+id+" founded");
		else {
			List<Salle> salles = salleRepository.findByCinema(id);
			for(Salle s : salles)
				salleRepository.delete(s);

			cinemaRepository.delete(cinema.get()); 
		}
	}

	@Override
	public List<Cinema> findAll(int page, int limit) {
		Pageable pageable = PageRequest.of(page,limit);
		Page<Cinema> cinemas = cinemaRepository.findAll(pageable);
		if(cinemas == null)
			return new ArrayList<Cinema>();
		else
			return cinemas.toList();
	}

	@Override
	public Cinema addCinema(Cinema cinema) {
		Cinema cinemaR = cinemaRepository.findByNom(cinema.getNom());
		if(cinemaR.getLongitude() == cinema.getLongitude() && cinemaR.getAltitude()==cinema.getAltitude() && cinemaR.getAtitude()==cinema.getAtitude()) 
			throw new EntityExistsException("A cinema in the same position aready exist change position an d try again");
		else {
			cinemaRepository.save(cinema);
			return cinema;
		}
	}

}
