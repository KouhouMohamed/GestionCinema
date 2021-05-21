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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.SalleService;
import com.kouhou.jee.entities.Salle;

@RestController
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	SalleService salleService;
	
	@GetMapping(path = "/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<Salle> getSalle(@PathVariable Long id) {
		Salle salle = salleService.findSalle(id);
		return new ResponseEntity<Salle>(salle,HttpStatus.OK);
	}
	
	@GetMapping(
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<Salle>> getByNombrePlace(@RequestParam int nombre,@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findByNombrePlace(nombre, page, limit);
		return new ResponseEntity<List<Salle>>(salles,HttpStatus.OK);
	}
	
	@GetMapping(
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<Salle>> getByCinema(@RequestParam Long idCinema,@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findByCinema(idCinema, page, limit);
		return new ResponseEntity<List<Salle>>(salles,HttpStatus.OK);
	}
	
	@GetMapping(path="/all",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<Salle>> getAll(@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findAll(page, limit);
		return new ResponseEntity<List<Salle>>(salles,HttpStatus.OK);
	}
	
	@PostMapping(path = "/add",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
		Salle salleR = salleService.addSalle(salle);
		return new ResponseEntity<Salle>(salleR,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/edit/{numero}",
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Salle> updateSalle(@PathVariable Long numero,@RequestBody Salle salle){
		Salle salleR= salleService.upadateSalle(numero, salle);
		return new ResponseEntity<Salle>(salleR,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Salle> deleteSalle(@PathVariable Long id){
		salleService.deleteSalle(id);
		return new ResponseEntity<Salle>(HttpStatus.NO_CONTENT);
	}
	
}
