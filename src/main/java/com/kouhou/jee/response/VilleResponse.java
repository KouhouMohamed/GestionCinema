package com.kouhou.jee.response;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VilleResponse {

	private Long id;
	
	private String nom;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
	
	private List<String> cinemas;

	public VilleResponse(Long id, String nom, double atitude, double longitude, double altitude) {
		super();
		this.id = id;
		this.nom = nom;
		this.atitude = atitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.cinemas = new ArrayList<String>();
	}
	
}
