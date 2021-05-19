package com.kouhou.jee.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kouhou.jee.Service.FilmService;
import com.kouhou.jee.entities.Film;
import com.kouhou.jee.repositories.FilmRepository;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepository;
	
	@Override
	public Film findFilm(Long id) {
		Optional<Film> film = filmRepository.findById(id);
		if(film == null)
			throw new EntityNotFoundException("Film with id "+id+" not found");
		else 
			return film.get();
	}

	@Override
	public List<Film> findByTitel(String titre, int page, int limit) {
		Pageable pageable =  PageRequest.of(page, limit);
		Page<Film> films = filmRepository.findByTitre(titre,pageable);
		if(films == null)
			throw new EntityNotFoundException("Film with title "+titre+" is founded");
		else
			return films.toList();
	}

	@Override
	public List<Film> findByRealisateur(String realisateur, int page, int limit) {
		Pageable pageable =  PageRequest.of(page, limit);
		Page<Film> films = filmRepository.findByRealisateur(realisateur, pageable);
		if(films == null)
			throw new EntityNotFoundException("No Films of "+realisateur+" not founded");
		else
			return films.toList();
	}

	@Override
	public List<Film> findByDuree(double duree, int page, int limit) {
		Pageable pageable =  PageRequest.of(page, limit);
		Page<Film> films = filmRepository.findByDuree(duree,pageable);
		if(films == null)
			throw new EntityNotFoundException("Films with duree "+duree+" not founded");
		else
			return films.toList();
	}

	@Override
	public List<Film> findByDate(Date dateSortie, int page, int limit) {
		Pageable pageable =  PageRequest.of(page, limit);
		Page<Film> films = filmRepository.findByDateSortie(dateSortie,pageable);
		if(films == null)
			throw new EntityNotFoundException("Films in date "+dateSortie+" not founded");
		else
			return films.toList();
	}

	@Override
	public void deleteFilm(Long id) {
		Optional<Film> film = filmRepository.findById(id);
		
		if(film == null)
			throw new EntityNotFoundException("No film with id "+id+"is founed");
		else
			filmRepository.delete(film.get());

	}

}
