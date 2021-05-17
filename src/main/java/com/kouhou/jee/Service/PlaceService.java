package com.kouhou.jee.Service;

import com.kouhou.jee.entities.Place;

public interface PlaceService {

	public Place findPlace(int numero);
	
	public Place findByPosition(double atitude, double longitude, double altitude);
	
	public Place updatePlace(Long id, Place place);
	
	public void deletePlace(Long id);
}
