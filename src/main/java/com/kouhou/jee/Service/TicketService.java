package com.kouhou.jee.Service;

import java.util.List;

import com.kouhou.jee.entities.Ticket;

public interface TicketService {

	public Ticket findTicket(String nomClient);
	
	public List<Ticket> findReservedTicket(boolean reservee, int page, int limit);
	
	public Ticket updateTicket(Long id, Ticket ticket);
	
	public void deleteTicket(Long id);
}
