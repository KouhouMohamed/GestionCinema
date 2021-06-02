package com.kouhou.jee.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CinemaResponse {

	private Long id;
	
	private String nom;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
	
	private int nombreSalles;
	
	private String ville;
	
	private List<SalleResponse> salles;

	public CinemaResponse(Long id, String nom, double atitude, double longitude, double altitude, int nombreSalles,
			String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.atitude = atitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.nombreSalles = nombreSalles;
		this.ville = ville;
		this.salles = new ArrayList<SalleResponse>();
	}
	
}
