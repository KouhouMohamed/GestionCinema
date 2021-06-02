package com.kouhou.jee.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.kouhou.jee.Service.CategorieService;
import com.kouhou.jee.entities.Categorie;
import com.kouhou.jee.response.CategorieResponse;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

	@Autowired
	private CategorieService catService;
	
	@GetMapping(
			path = "/{name}", 
			produces = {MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<CategorieResponse> getCategorie(@PathVariable String name){
		Categorie categorie = catService.findCategorie(name);
		ModelMapper modelMapper = new ModelMapper();
		return new ResponseEntity<>(modelMapper.map(categorie.map(),CategorieResponse.class),HttpStatus.OK);
	}
	
	@GetMapping(
			path = "/all", 
			produces = { 
					MediaType.APPLICATION_JSON_VALUE 
					})
	public ResponseEntity<List<CategorieResponse>> getCategories(@RequestParam int page,@RequestParam int limit){
		List<Categorie> cats = catService.findAllCategories(page, limit);
		List<CategorieResponse> catRs = new ArrayList<CategorieResponse>();
		for(Categorie cat : cats)
			catRs.add(cat.map());
		return new ResponseEntity<List<CategorieResponse>>(catRs,HttpStatus.OK);
		
	}
	@PostMapping(
			path = "/add", 
			produces = { 
					MediaType.APPLICATION_JSON_VALUE 
					})
	public ResponseEntity<CategorieResponse> addCategorie(Categorie cat){
		Categorie categorie = catService.addCategorie(cat);
		return new ResponseEntity<>(categorie.map(),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path="/edit/{name}",
			produces = { 
			MediaType.APPLICATION_JSON_VALUE 
			})
	public ResponseEntity<CategorieResponse> updateCategorie(@PathVariable String name, Categorie cat) {
		Categorie categorie = catService.updateCategorie(name, cat);
;		return new ResponseEntity<CategorieResponse>(categorie.map(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/delete/{name}")
	public ResponseEntity<Object> deleteCategorie(@PathVariable String name){
		catService.deleteCategorie(name);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
