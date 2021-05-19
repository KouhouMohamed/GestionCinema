package com.kouhou.jee.ServiceImpl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kouhou.jee.Service.PlaceService;
import com.kouhou.jee.entities.Place;
import com.kouhou.jee.repositories.PlaceRepository;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService{

	@Autowired
	PlaceRepository placeRepository;
	
	@Override
	public Place findPlace(Long id) {
		Optional<Place> place = placeRepository.findById(id);
		if(place==null)
			throw new EntityNotFoundException("No Place with id "+id+" is founded");
		else 
			return place.get();
	}

	@Override
	public Place findByPosition(double atitude, double longitude, double altitude) {
		Place place = placeRepository.findByPosition(atitude, longitude, altitude);
		if(place==null)
			throw new EntityNotFoundException("No place in ("+atitude+","+longitude+","+altitude+") founded");
		else 
			return place;
	}

	@Override
	public Place updatePlace(Long id, Place place) {
		Optional<Place> placeR = placeRepository.findById(id);
		if (placeR == null)
			throw new EntityNotFoundException("No Place with id "+id+" is founded");
		else {
			place.setId(placeR.get().getId());
			placeRepository.save(place);
			return place;
		}
	}

	@Override
	public void deletePlace(Long id) {
		Optional<Place> place = placeRepository.findById(id);
		if (place == null)
			throw new EntityNotFoundException("No Place with id "+id+" is founded");
		else
			placeRepository.delete(place.get());
		
	}

}
