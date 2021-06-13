package com.kouhou.jee.response;

import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.kouhou.jee.entities.Place;
import com.kouhou.jee.entities.Projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {

	private Long id;
	
	private String nomClient;
	
	private double prix;
	 
	private int codePayement;
	
	private boolean reservee;
	
	private int place;
	
	private Long projection;
}
