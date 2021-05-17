package com.kouhou.jee.Service;

import com.kouhou.jee.entities.Ville;

public interface VilleService {

	public Ville findVille(String nom);
	
	public Ville findByPosition(double atitude, double longitude, double altitude);

	public Ville updateVille(String name, Ville ville);
	
	public void deleteVille(String nom);
}
