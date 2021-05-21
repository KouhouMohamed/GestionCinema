package com.kouhou.jee.Service;

import java.util.List;

import com.kouhou.jee.entities.Ville;

public interface VilleService {

	public Ville findVille(String nom);
	
	public List<Ville> findAll(int page, int limit);
	
	public Ville findByPosition(double atitude, double longitude, double altitude);

	public Ville updateVille(Long id, Ville ville);
	
	public Ville addVille(Ville ville);
	
	public void deleteVille(Long id);
}
