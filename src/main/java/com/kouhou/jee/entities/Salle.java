<<<<<<< HEAD
package com.kouhou.jee.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.kouhou.jee.response.SalleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
@Entity
public class Salle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
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
	
	public SalleResponse map() {
		SalleResponse salle = new SalleResponse(id, nom, nombrePlaces, cinema.getNom());
		for(Place place : places)
			salle.getPlaces().add(place.map());
		return salle;
	}
}
=======
package com.kouhou.jee.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.kouhou.jee.response.SalleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
@Entity
public class Salle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
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
	
	public SalleResponse map() {
		SalleResponse salle = new SalleResponse(id, nom, nombrePlaces, cinema.getNom());
		for(Place place : places)
			salle.getPlaces().add(place.map());
		return salle;
	}
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
