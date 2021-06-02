package com.kouhou.jee.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalleResponse {

	private Long id;
	
	private String nom;
	
	private int nombrePlaces;
	
	private String cinema;
	
	private List<PlaceResponse> places;

	public SalleResponse(Long id, String nom, int nombrePlaces, String cinema) {
		super();
		this.id = id;
		this.nom = nom;
		this.nombrePlaces = nombrePlaces;
		this.cinema = cinema;
		this.places = new ArrayList<PlaceResponse>();
	}
	
}
