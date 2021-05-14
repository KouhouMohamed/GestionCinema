package com.kouhou.jee.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table
public class Ville {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=15)
	private String nom;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
	
	@OneToMany(mappedBy = "ville")
	private List<Cinema> cinemas;
}
