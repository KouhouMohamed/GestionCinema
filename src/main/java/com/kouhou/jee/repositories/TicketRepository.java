package com.kouhou.jee.repositories;

import org.springframework.data.domain.Page;

import com.kouhou.jee.entities.Ticket;

public interface TicketRepository {

	public Ticket findById(Long id);
	
	public Ticket findByNomClient(String nomCient);

	public Ticket findByCodePayement(int codePayement);
	
	public Page<Ticket> findByReservee(boolean reservee);
	
	public Page<Ticket> findByPrix(double prix);
	
	
	
}
