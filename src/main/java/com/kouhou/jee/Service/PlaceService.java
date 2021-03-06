package com.kouhou.jee.Service;

import java.util.List;

import com.kouhou.jee.entities.Place;

public interface PlaceService {

	public Place findPlace(Long id);
	
	public Place findByPosition(double atitude, double longitude, double altitude);
	
	public Place updatePlace(Long id, Place place);
	
	public List<Place> findAll(int page, int limit);
	
	public Place addPlace(Place place);
	
	public void deletePlace(Long id);
}
