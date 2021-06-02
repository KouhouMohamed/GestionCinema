package com.kouhou.jee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.kouhou.jee.response.ProjectionResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
@Entity
public class Projection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateProjection;
	
	private double prix;
	
	@ManyToOne
	private Film film;
	
	@ManyToOne
	private Salle salle;
	
	@OneToMany(mappedBy = "projection")
	private List<Ticket> tickets;
	
	public ProjectionResponse map() {
		
		ProjectionResponse projection = new ProjectionResponse(id, dateProjection, prix, film.getTitre(), salle.getNom());
		return projection;
	}
	//private Seance seance;
}
