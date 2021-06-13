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


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.kouhou.jee.response.CinemaResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table
@Entity
public class Cinema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	public CinemaResponse map() {
		CinemaResponse cinema = new CinemaResponse(id, nom,atitude,longitude,altitude,nombreSalles,ville.getNom());
		for(Salle salle : salles)
			cinema.getSalles().add(salle.map());
		return cinema;
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


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.kouhou.jee.response.CinemaResponse;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table
@Entity
public class Cinema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	public CinemaResponse map() {
		CinemaResponse cinema = new CinemaResponse(id, nom,atitude,longitude,altitude,nombreSalles,ville.getNom());
		for(Salle salle : salles)
			cinema.getSalles().add(salle.map());
		return cinema;
	}
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
