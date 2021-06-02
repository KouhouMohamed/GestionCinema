package com.kouhou.jee.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponse {

	private Long id;
	
	private int numero;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
	
	private String salle;
}
