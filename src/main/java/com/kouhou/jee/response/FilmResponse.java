<<<<<<< HEAD
package com.kouhou.jee.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kouhou.jee.entities.Projection;

import lombok.Data;

@Data
public class FilmResponse {
	
	private Long id;
	private String titre;
	private double duree;
	private String realisateur;
	private String description;
	private String photo;
	private Date dateSortie;
	private String categorie;
	private List<Projection> projections;
	
	public FilmResponse(Long id, String titre, double duree, String realisateur, String description, String photo,
			Date dateSortie, String categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.photo = photo;
		this.dateSortie = dateSortie;
		this.categorie = categorie;
		this.projections = new ArrayList<Projection>();
	}
	
	
}
=======
package com.kouhou.jee.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kouhou.jee.entities.Projection;

import lombok.Data;

@Data
public class FilmResponse {
	
	private Long id;
	private String titre;
	private double duree;
	private String realisateur;
	private String description;
	private String photo;
	private Date dateSortie;
	private String categorie;
	private List<Projection> projections;
	
	public FilmResponse(Long id, String titre, double duree, String realisateur, String description, String photo,
			Date dateSortie, String categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.photo = photo;
		this.dateSortie = dateSortie;
		this.categorie = categorie;
		this.projections = new ArrayList<Projection>();
	}
	
	
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
