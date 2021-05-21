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

import com.kouhou.jee.Service.VilleService;
import com.kouhou.jee.entities.Ville;

@RestController
@RequestMapping("/ville")
public class VillerController {

	@Autowired
	VilleService villeService;
	
	@GetMapping(path="/{nom}",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Ville> getVille(@PathVariable String nom){
		Ville ville = villeService.findVille(nom);
		return new ResponseEntity<Ville>(ville,HttpStatus.OK);
		
	}
	
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Ville>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Ville> villes = villeService.findAll(page, limit);
		return new ResponseEntity<List<Ville>>(villes,HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Ville> getByPosition(@RequestParam double atitude, @RequestParam double longitude, @RequestParam double altitude) {
		Ville ville =  villeService.findByPosition(atitude, longitude, altitude);
		return new ResponseEntity<Ville>(ville,HttpStatus.OK);
	}
	
	@PostMapping(path="/add",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Ville> addVille(@RequestBody Ville ville){
	Ville villeR = villeService.addVille(ville);
	return new ResponseEntity<Ville>(ville,HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/edit/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Ville> updateVille(@PathVariable Long id, @RequestBody Ville ville){
		Ville villeR = villeService.updateVille(id, ville);
		return new ResponseEntity<Ville>(villeR,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Ville> deleteVille(@PathVariable Long id){
		villeService.deleteVille(id);
		return new ResponseEntity<Ville>(HttpStatus.NO_CONTENT);
	}
}
