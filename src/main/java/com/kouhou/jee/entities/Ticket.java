package com.kouhou.jee.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.Entity;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
@Entity
public class Ticket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 15, min = 3)
	private String nomClient;
	
	@DecimalMin(value = "0")
	private double prix;
	 
	private int codePayement;
	
	private boolean reservee;
	
	@ManyToOne
	private Place place;
	
	@ManyToOne
	private Projection projection;
}
