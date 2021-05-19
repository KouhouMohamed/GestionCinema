package com.kouhou.jee.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table
@Entity
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=15)
	private String nom;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
	
	@DecimalMin(value = "0")
	private int nombreSalles;
	
	@ManyToOne
	private Ville ville;
	
	@OneToMany(mappedBy = "cinema")
	private List<Salle> salles;
}
