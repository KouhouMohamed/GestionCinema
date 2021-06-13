<<<<<<< HEAD
package com.kouhou.jee.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.SeanceService;
import com.kouhou.jee.entities.Seance;

@RestController
@RequestMapping("/seance")
public class SeanceController {

	@Autowired
	SeanceService seanceService;
	
	@GetMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<Seance> getSenace(@PathVariable Long id) {
		Seance seance = seanceService.findSeance(id);
		return new ResponseEntity<Seance>(seance,HttpStatus.OK);
	}
	
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Seance>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Seance> seances = seanceService.findAll(page,limit);
		return new ResponseEntity<List<Seance>>(seances,HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Seance>> getByDate(@RequestParam Date date,@RequestParam int page, @RequestParam int limit){
		List<Seance> seances = seanceService.findByDate(date,page,limit);
		return new ResponseEntity<List<Seance>>(seances,HttpStatus.OK);
	}
	
	@PutMapping(path="/edit/{id}",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Seance> updateSeance(@PathVariable Long id, @RequestBody Seance seance){
		Seance seanceR = seanceService.updateSeance(id, seance);
		return new ResponseEntity<Seance>(seanceR,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Seance> deleteSeance(@PathVariable Long id){
		seanceService.deleteSeance(id);
		return new ResponseEntity<Seance>(HttpStatus.NO_CONTENT);
	}
}
=======
package com.kouhou.jee.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.SeanceService;
import com.kouhou.jee.entities.Seance;

@RestController
@RequestMapping("/seance")
public class SeanceController {

	@Autowired
	SeanceService seanceService;
	
	@GetMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<Seance> getSenace(@PathVariable Long id) {
		Seance seance = seanceService.findSeance(id);
		return new ResponseEntity<Seance>(seance,HttpStatus.OK);
	}
	
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Seance>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Seance> seances = seanceService.findAll(page,limit);
		return new ResponseEntity<List<Seance>>(seances,HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Seance>> getByDate(@RequestParam Date date,@RequestParam int page, @RequestParam int limit){
		List<Seance> seances = seanceService.findByDate(date,page,limit);
		return new ResponseEntity<List<Seance>>(seances,HttpStatus.OK);
	}
	
	@PutMapping(path="/edit/{id}",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Seance> updateSeance(@PathVariable Long id, @RequestBody Seance seance){
		Seance seanceR = seanceService.updateSeance(id, seance);
		return new ResponseEntity<Seance>(seanceR,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Seance> deleteSeance(@PathVariable Long id){
		seanceService.deleteSeance(id);
		return new ResponseEntity<Seance>(HttpStatus.NO_CONTENT);
	}
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
