package com.kouhou.jee.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
public class Place {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DecimalMin(value = "0")
	private int numero;
	
	private double atitude;
	
	private double longitude;
	
	private double altitude;
}