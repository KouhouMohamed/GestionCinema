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

import com.kouhou.jee.response.PlaceResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
@Entity
public class Place implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DecimalMin(value = "0")
	private int numero;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
	
	@ManyToOne
	private Salle salle;
	
	@OneToMany(mappedBy = "place")
	private List<Ticket> tickets;
	
	public PlaceResponse map() {
		PlaceResponse place = new PlaceResponse(id, numero, atitude, longitude, altitude, salle.getNom());
		return place;
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

import com.kouhou.jee.response.PlaceResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
@Entity
public class Place implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DecimalMin(value = "0")
	private int numero;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
	
	@ManyToOne
	private Salle salle;
	
	@OneToMany(mappedBy = "place")
	private List<Ticket> tickets;
	
	public PlaceResponse map() {
		PlaceResponse place = new PlaceResponse(id, numero, atitude, longitude, altitude, salle.getNom());
		return place;
	}
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
