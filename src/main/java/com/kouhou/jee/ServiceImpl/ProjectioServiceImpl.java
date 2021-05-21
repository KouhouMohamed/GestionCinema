package com.kouhou.jee.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kouhou.jee.Service.ProjectionService;
import com.kouhou.jee.entities.Projection;
import com.kouhou.jee.repositories.ProjectionRepository;


public class ProjectioServiceImpl implements ProjectionService {

	@Autowired
	ProjectionRepository projectionRepository;
	
	@Override
	public List<Projection> findByPrice(double prix, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Projection> projections = projectionRepository.findByPrix(prix, pageable);
		if(projections == null)
			throw new EntityNotFoundException("No projections founded");
		else
			return projections.toList();
	}

	@Override
	public List<Projection> findBydate(Date date, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Projection> projections = projectionRepository.findBydateProjection(date, pageable);
		if(projections == null)
			throw new EntityNotFoundException("No projections founded");
		else
			return projections.toList();
	}

	@Override
	public Projection updateProjection(Long id, Projection projection) {
		if(projection == null)
			throw new EntityNotFoundException("Projection with id "+id+" not found");
		else {
			projection.setId(id);
			projectionRepository.save(projection);
			return projection;
		}
	}

	@Override
	public void deleteProjection(Long id) {
		Optional<Projection> projection = projectionRepository.findById(id);
		if(projection == null)
			throw new EntityNotFoundException("Projection with id "+id+" not found");
		else
			projectionRepository.delete(projection.get());
	}

	@Override
	public Projection findProjection(Long id) {
		Optional<Projection> proj = projectionRepository.findById(id);
		if(proj == null)
			throw new EntityNotFoundException("No projection with id "+id+" is founded");
		else
			return proj.get();
	}

	@Override
	public List<Projection> findProjectionsByDate(Date date, Long id_salle, Long id_film) {
		List<Projection> projs = projectionRepository.findByDateAndSalle(date, id_salle, id_film);
		if(projs == null)
			return new ArrayList<Projection>();
		else
			return projs;
	}

}
