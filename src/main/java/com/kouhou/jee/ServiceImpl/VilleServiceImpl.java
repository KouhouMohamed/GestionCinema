package com.kouhou.jee.ServiceImpl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kouhou.jee.Service.VilleService;
import com.kouhou.jee.entities.Ville;
import com.kouhou.jee.repositories.VilleRepository;

public class VilleServiceImpl implements VilleService{

	@Autowired
	VilleRepository villeRepository;
	
	@Override
	public Ville findVille(String nom) {
		Ville ville =  villeRepository.findByNom(nom);
		if(ville==null)
			throw new EntityNotFoundException("No ville with nom "+nom+" is founded");
		else 
			return ville;
	}

	@Override
	public Ville findByPosition(double atitude, double longitude, double altitude) {
		Ville ville = villeRepository.findByPosition(atitude, longitude, altitude);
		if(ville==null)
			throw new EntityNotFoundException("No ville in position ("+atitude+","+longitude+","+altitude+") is founded");
		else 
			return ville;
	}

	@Override
	public Ville updateVille(Long id, Ville ville) {
Optional<Ville> villeR =  villeRepository.findById(id);
		
		if(villeR==null)
			throw new EntityNotFoundException("No ville with id "+id+" is founded");
		else {
			ville.setId(id);
			villeRepository.delete(villeR.get());
			villeRepository.save(ville);
			return ville;
		}
			
	}
/*
 * By delete ville we delete cinemas
 * */
	@Override
	public void deleteVille(Long id) {
		Optional<Ville> ville =  villeRepository.findById(id);
		
		if(ville==null)
			throw new EntityNotFoundException("No ville with id "+id+" is founded");
		else
			villeRepository.delete(ville.get());
		
	}

}
