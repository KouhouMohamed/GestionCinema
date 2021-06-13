<<<<<<< HEAD
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.SalleService;
import com.kouhou.jee.entities.Salle;
import com.kouhou.jee.response.SalleResponse;

@RestController
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	SalleService salleService;
	
	@GetMapping(path = "/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<SalleResponse> getSalle(@PathVariable Long id) {
		Salle salle = salleService.findSalle(id);
		return new ResponseEntity<SalleResponse>(salle.map(),HttpStatus.OK);
	}
	
	@GetMapping(
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<SalleResponse>> getByNombrePlace(@RequestParam int nombre,@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findByNombrePlace(nombre, page, limit);
		List<SalleResponse> salleRs = new ArrayList<SalleResponse>();
		for(Salle salle : salles)
			salleRs.add(salle.map());
		return new ResponseEntity<List<SalleResponse>>(salleRs,HttpStatus.OK);
	}
	
	@GetMapping(path = "/cinema/{idCinema}",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<SalleResponse>> getByCinema(@PathVariable Long idCinema,@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findByCinema(idCinema, page, limit);
		List<SalleResponse> salleRs = new ArrayList<SalleResponse>();
		for(Salle salle : salles)
			salleRs.add(salle.map());
		return new ResponseEntity<List<SalleResponse>>(salleRs,HttpStatus.OK);
	}
	
	@GetMapping(path="/all",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<SalleResponse>> getAll(@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findAll(page, limit);
		List<SalleResponse> salleRs = new ArrayList<SalleResponse>();
		for(Salle salle : salles)
			salleRs.add(salle.map());
		return new ResponseEntity<List<SalleResponse>>(salleRs,HttpStatus.OK);
	}
	
	@PostMapping(path = "/add",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<SalleResponse> addSalle(@RequestBody Salle salle){
		Salle salleR = salleService.addSalle(salle);
		return new ResponseEntity<SalleResponse>(salleR.map(),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/edit/{numero}",
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SalleResponse> updateSalle(@PathVariable Long numero,@RequestBody Salle salle){
		Salle salleR= salleService.upadateSalle(numero, salle);
		return new ResponseEntity<SalleResponse>(salleR.map(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<SalleResponse> deleteSalle(@PathVariable Long id){
		salleService.deleteSalle(id);
		return new ResponseEntity<SalleResponse>(HttpStatus.NO_CONTENT);
	}
	
}
=======
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.SalleService;
import com.kouhou.jee.entities.Salle;
import com.kouhou.jee.response.SalleResponse;

@RestController
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	SalleService salleService;
	
	@GetMapping(path = "/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<SalleResponse> getSalle(@PathVariable Long id) {
		Salle salle = salleService.findSalle(id);
		return new ResponseEntity<SalleResponse>(salle.map(),HttpStatus.OK);
	}
	
	@GetMapping(
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<SalleResponse>> getByNombrePlace(@RequestParam int nombre,@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findByNombrePlace(nombre, page, limit);
		List<SalleResponse> salleRs = new ArrayList<SalleResponse>();
		for(Salle salle : salles)
			salleRs.add(salle.map());
		return new ResponseEntity<List<SalleResponse>>(salleRs,HttpStatus.OK);
	}
	
	@GetMapping(path = "/cinema/{idCinema}",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<SalleResponse>> getByCinema(@PathVariable Long idCinema,@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findByCinema(idCinema, page, limit);
		List<SalleResponse> salleRs = new ArrayList<SalleResponse>();
		for(Salle salle : salles)
			salleRs.add(salle.map());
		return new ResponseEntity<List<SalleResponse>>(salleRs,HttpStatus.OK);
	}
	
	@GetMapping(path="/all",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<List<SalleResponse>> getAll(@RequestParam int page,@RequestParam int limit) {
		List<Salle> salles = salleService.findAll(page, limit);
		List<SalleResponse> salleRs = new ArrayList<SalleResponse>();
		for(Salle salle : salles)
			salleRs.add(salle.map());
		return new ResponseEntity<List<SalleResponse>>(salleRs,HttpStatus.OK);
	}
	
	@PostMapping(path = "/add",
			produces = {MediaType.APPLICATION_JSON_VALUE }
	)
	public ResponseEntity<SalleResponse> addSalle(@RequestBody Salle salle){
		Salle salleR = salleService.addSalle(salle);
		return new ResponseEntity<SalleResponse>(salleR.map(),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/edit/{numero}",
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SalleResponse> updateSalle(@PathVariable Long numero,@RequestBody Salle salle){
		Salle salleR= salleService.upadateSalle(numero, salle);
		return new ResponseEntity<SalleResponse>(salleR.map(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<SalleResponse> deleteSalle(@PathVariable Long id){
		salleService.deleteSalle(id);
		return new ResponseEntity<SalleResponse>(HttpStatus.NO_CONTENT);
	}
	
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
