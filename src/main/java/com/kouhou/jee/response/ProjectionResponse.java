<<<<<<< HEAD
package com.kouhou.jee.response;

import java.util.Date;

import com.kouhou.jee.entities.Film;
import com.kouhou.jee.entities.Salle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjectionResponse {

	private Long id;
	
	private Date dateProjection;
	
	private double prix;
	
	private String film;
	
	private String salle;
}
=======
package com.kouhou.jee.response;

import java.util.Date;

import com.kouhou.jee.entities.Film;
import com.kouhou.jee.entities.Salle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProjectionResponse {

	private Long id;
	
	private Date dateProjection;
	
	private double prix;
	
	private String film;
	
	private String salle;
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
