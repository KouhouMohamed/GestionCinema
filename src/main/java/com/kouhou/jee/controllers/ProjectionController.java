package com.kouhou.jee.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.ProjectionService;
import com.kouhou.jee.entities.Projection;
import com.kouhou.jee.response.ProjectionResponse;

@RestController
@RequestMapping("/projection")
public class ProjectionController {

	@Autowired 
	ProjectionService projectionService;
	
	@GetMapping(path="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProjectionResponse> getProjection(@PathVariable Long id){
		Projection projection = projectionService. findProjection(id);
		return new ResponseEntity<ProjectionResponse>(projection.map(),HttpStatus.OK);
	}
	
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ProjectionResponse>> getAll(@RequestParam int page,@RequestParam int limit){
		List<Projection> projections =  projectionService.findAll(page, limit);
		List<ProjectionResponse> projectionRs = new ArrayList<ProjectionResponse>();
		for(Projection proj : projections)
			projectionRs.add(proj.map());
		return new ResponseEntity<List<ProjectionResponse>>(projectionRs,HttpStatus.OK);
	}
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<ProjectionResponse> deleteProjection(@PathVariable Long id) {
		projectionService.deleteProjection(id);
		return new ResponseEntity<ProjectionResponse>(HttpStatus.NO_CONTENT);
	}
	public ResponseEntity<ProjectionResponse> updateProjection(@PathVariable Long id,@RequestParam Projection projection){
		Projection proj = projectionService.updateProjection(id, projection);
		return new ResponseEntity<ProjectionResponse>(proj.map(),HttpStatus.ACCEPTED);
	}	
}