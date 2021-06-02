package com.kouhou.jee.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

	@Override
	public List<Place> findAll(int page, int limit) {
		List<Place> places = placeRepository.findAll();
		if(places == null)
			return new ArrayList<Place>();
		else
			return places;
	}

	@Override
	public Place addPlace(Place place) {
		List<Place> places = placeRepository.findBySalle(place.getSalle().getId());
		boolean exist = false;
		if(places!=null && places.size()!=0) {
			for(Place p : places) {
				if(p.getNumero()==place.getNumero()) {
					exist = true;
					break;
				}
			}
		}
		if(!exist)
			placeRepository.save(place);
		return place;
	}

}
