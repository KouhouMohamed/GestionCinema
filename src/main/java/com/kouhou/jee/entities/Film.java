package com.kouhou.jee.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.kouhou.jee.response.FilmResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Film implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Size(min = 3, max = 30)
	private String titre;
	
	@Column(nullable = false)
	private double duree;
	
	@Column(nullable = false)
	private String realisateur;
	
	@Column(nullable = false)
	@Size(min = 3, max = 100)
	private String description;
	
	@Column(nullable = false)
	private String photo;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateSortie;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private Categorie categorie;
	
	@Column(nullable = true)
	@OneToMany(mappedBy = "film")
	private List<Projection> projections;
	
	public FilmResponse map() {
		FilmResponse filmRes = new FilmResponse(id, description, duree, description, description, description, dateSortie, description);
		
		return filmRes;
	}
	public boolean equal(Film film) {
		return (this.titre.equals(film.getTitre())&&this.duree==film.getDuree()&&this.realisateur.equals(film.getRealisateur())&&this.dateSortie.equals(film.getDateSortie())&&this.description.equals(film.getDescription()));
	}
}
