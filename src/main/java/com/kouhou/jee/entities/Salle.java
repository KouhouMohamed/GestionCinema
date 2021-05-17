package com.kouhou.jee.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
public class Salle {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numero;
	
	@Size(max = 15, min = 3)
	private String nom;
	
	@DecimalMin(value = "0")
	private int nombrePlaces;
	
	@ManyToOne
	private Cinema cinema;
	
	@OneToMany(mappedBy = "salle")
	private List<Place> places;

	@OneToMany(mappedBy = "salle")
	private List<Projection> projections;
}
