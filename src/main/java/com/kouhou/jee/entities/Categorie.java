package com.kouhou.jee.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.kouhou.jee.response.CategorieResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 15, min = 3)
	private String name;
	
	@Column(nullable = true)
	@OneToMany(mappedBy = "categorie")
	private List<Film> films;
	
	public CategorieResponse map() {
		CategorieResponse cat = new CategorieResponse(id,name);
		return cat;
	}
}
