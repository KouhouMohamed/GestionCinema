package com.kouhou.jee.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	public Ticket findByNomClient(String nomCient);

	public Ticket findByCodePayement(int codePayement);
	
	public Page<Ticket> findByReservee(boolean reservee, Pageable pageable);
	
	public Page<Ticket> findByPrix(double prix);
	
	
	
}
