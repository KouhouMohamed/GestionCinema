package com.kouhou.jee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.PlaceService;
import com.kouhou.jee.entities.Place;

@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	PlaceService placeService;
	
	@GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Place> getPlace(@PathVariable Long id) {
		Place place = placeService.findPlace(id);
		return new ResponseEntity<Place>(place,HttpStatus.OK);
	}
	
	@GetMapping(path="/position",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<Place> getByPosition(@RequestParam int atitude,@RequestParam int longitude,@RequestParam int altitude){
		Place place = placeService.findByPosition(atitude, longitude, altitude);
		return new ResponseEntity<Place>(place,HttpStatus.OK);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<Place>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Place> places = placeService.findAll(page, limit);
		return new ResponseEntity<List<Place>>(places,HttpStatus.OK);
	}
	
	@PostMapping(path="/add",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Place> addPlace( Place place){
		Place palce = placeService.addPlace(place);
		return new ResponseEntity<Place>(palce,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/edit/{id}")
	public ResponseEntity<Place> updatePlace(Long id, Place place){
		Place placeR = placeService.updatePlace(id, place);
		return new ResponseEntity<Place>(placeR,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Place> deletePlace(@PathVariable Long id){
		placeService.deletePlace(id);
		return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
	}
	
}
