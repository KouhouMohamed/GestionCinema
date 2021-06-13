package com.kouhou.jee.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.kouhou.jee.Service.FilmService;
import com.kouhou.jee.entities.Film;
import com.kouhou.jee.response.FilmResponse;

@RestController
@RequestMapping("/film")
public class FilmController {

	@Autowired
	FilmService filmService;
	
	@GetMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<FilmResponse> getFilm(@PathVariable Long id){
		Film film = filmService.findFilm(id);
		FilmResponse filmResp = film.map();
		return new ResponseEntity<FilmResponse>(filmResp,HttpStatus.OK);
	}
	
	@GetMapping(path="/{titre}",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<List<FilmResponse>> getByTitre(@PathVariable String titre, int page, int limit){
		List<Film> films = filmService.findByTitel(titre, page, limit);
		List<FilmResponse> filmResps = new ArrayList<FilmResponse>();
		for(Film film : films) {
			filmResps.add(film.map());
		}
		return new ResponseEntity<List<FilmResponse>>(filmResps,HttpStatus.OK);
	}
	
	@GetMapping(path="/{realisateur}",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<List<FilmResponse>> getByRealisateur(@PathVariable String realisateur, int page, int limit){
		List<Film> films = filmService.findByRealisateur(realisateur, page, limit);
		List<FilmResponse> filmResps = new ArrayList<FilmResponse>();
		for(Film film : films) {
			filmResps.add(film.map());
		}
		return new ResponseEntity<List<FilmResponse>>(filmResps,HttpStatus.OK);
	}
	
	@GetMapping(path="/duree",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<List<FilmResponse>> getByDuree(@RequestParam double duree, int page, int limit){
		List<Film> films = filmService.findByDuree(duree, page, limit);
		List<FilmResponse> filmResps = new ArrayList<FilmResponse>();
		for(Film film : films) {
			filmResps.add(film.map());
		}
		return new ResponseEntity<List<FilmResponse>>(filmResps,HttpStatus.OK);
	}
	
	@GetMapping(path="/{dateSortie}",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<List<FilmResponse>> getByDate(@PathVariable Date dateSortie, int page, int limit){
		List<Film> films = filmService.findByDate(dateSortie, page, limit);
		List<FilmResponse> filmResps = new ArrayList<FilmResponse>();
		for(Film film : films) {
			filmResps.add(film.map());
		}
		return new ResponseEntity<List<FilmResponse>>(filmResps,HttpStatus.OK);
	}
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<List<FilmResponse>> getAll(int page, int limit){
		List<Film> films = filmService.findAll(page, limit);
		List<FilmResponse> filmResps = new ArrayList<FilmResponse>();
		for(Film film : films) {
			filmResps.add(film.map());
		}
		return new ResponseEntity<List<FilmResponse>>(filmResps,HttpStatus.OK);
	}
	@PutMapping(path = "/edit/{id}",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<FilmResponse> updateFilm(@PathVariable Long id, Film film){
		Film filmR = filmService.updateFilm(id, film);
		FilmResponse filmResp = filmR.map();
		return new ResponseEntity<FilmResponse>(filmResp,HttpStatus.OK);
	}
	
	@PostMapping(path = "/add",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<FilmResponse> addFilm(@RequestBody Film film){
		Film filmR = filmService.addFilm(film);
		FilmResponse filmResp = filmR.map();
		return new ResponseEntity<FilmResponse>(filmResp,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Film> deleteFilm(@PathVariable Long id) {
		filmService.deleteFilm(id);
		return new ResponseEntity<Film>(HttpStatus.NO_CONTENT);
	}
}
