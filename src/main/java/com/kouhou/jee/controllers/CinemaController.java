package com.kouhou.jee.controllers;

import java.util.ArrayList;
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

import com.kouhou.jee.Service.CinemaService;
import com.kouhou.jee.entities.Cinema;
import com.kouhou.jee.response.CinemaResponse;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
	
	@Autowired
	CinemaService cinemaService;
	
	@GetMapping(path = "/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CinemaResponse> getCinema(String name){
		Cinema cinema = cinemaService.findCinema(name);
		return new ResponseEntity<CinemaResponse>(cinema.map(),HttpStatus.OK);
	}
	
	@GetMapping(path="/ville/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CinemaResponse>> getByVille(@PathVariable String name, @RequestParam int page, @RequestParam int limit){
		List<Cinema> cinemas =  cinemaService.findByVille(name, page, limit);
		List<CinemaResponse> cinemaRs = new ArrayList<CinemaResponse>();
		for(Cinema cinema : cinemas)
			cinemaRs.add(cinema.map());
		return new ResponseEntity<List<CinemaResponse>>(cinemaRs,HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CinemaResponse>> getByNombreSalle(@RequestParam int nombreSalle, @RequestParam int page, @RequestParam int limit){
		List<Cinema> cinemas =  cinemaService.findByNombreSalles(nombreSalle, page, limit);
		List<CinemaResponse> cinemaRs = new ArrayList<CinemaResponse>();
		for(Cinema cinema : cinemas)
			cinemaRs.add(cinema.map());
		return new ResponseEntity<List<CinemaResponse>>(cinemaRs,HttpStatus.OK);
	}
	
	@GetMapping(path = "/all",produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<List<CinemaResponse>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Cinema> cinemas =  cinemaService.findAll(page, limit);
		List<CinemaResponse> cinemaRs = new ArrayList<CinemaResponse>();
		for(Cinema cinema : cinemas)
			cinemaRs.add(cinema.map());
		return new ResponseEntity<List<CinemaResponse>>(cinemaRs,HttpStatus.OK);
	}
	
	@GetMapping(path="/position",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CinemaResponse> getByPosition(@RequestParam int atitude,@RequestParam int longitude,@RequestParam int altitude){
		Cinema cinema = cinemaService.findByPosition(atitude, longitude, altitude);
		return new ResponseEntity<CinemaResponse>(cinema.map(),HttpStatus.OK);
	}
	
	@PostMapping(path="/add",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CinemaResponse> addCinema(Cinema cinema){
		Cinema cinemaR = cinemaService.addCinema(cinema);
		return new ResponseEntity<CinemaResponse>(cinemaR.map(),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/edit/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CinemaResponse> updateCinema(@PathVariable Long id, Cinema cinema) {
		Cinema cinemaR = cinemaService.updateCinema(id, cinema);
		return new ResponseEntity<CinemaResponse>(cinemaR.map(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Cinema> deleteCinema(@PathVariable Long id) {
		cinemaService.deleteCinema(id);
		return new ResponseEntity<Cinema>(HttpStatus.NO_CONTENT);
	}
	
}
