package com.kouhou.jee.Service;

import com.kouhou.jee.entities.Ville;

public interface VilleService {

	public Ville findVille(String nom);
	
	public Ville findByPosition(double atitude, double longitude, double altitude);

	public Ville updateVille(Long id, Ville ville);
	
	public void deleteVille(Long id);
}
