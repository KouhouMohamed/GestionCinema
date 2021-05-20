package com.kouhou.jee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.ProjectionService;
import com.kouhou.jee.entities.Projection;

@RestController
@RequestMapping("/projection")
public class ProjectionController {

	@Autowired 
	ProjectionService projectionService;
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Projection> getProjection(Long id){
		Projection projection = projectionService. findProjection(id);
		return new ResponseEntity<Projection>(projection,HttpStatus.OK);
	}
	
}