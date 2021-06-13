package com.kouhou.jee.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.kouhou.jee.response.VilleResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table
@Entity
public class Ville implements Serializable{

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
	
	@OneToMany(mappedBy = "ville")
	private List<Cinema> cinemas;
	
	public VilleResponse map() {
		VilleResponse ville = new VilleResponse(id, nom, atitude, longitude, altitude);
		for(Cinema cinema : cinemas)
			ville.getCinemas().add(cinema.getNom());
		return ville;
	}
}
