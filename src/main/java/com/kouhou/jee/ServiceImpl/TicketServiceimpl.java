package com.kouhou.jee.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kouhou.jee.Service.TicketService;
import com.kouhou.jee.entities.Ticket;
import com.kouhou.jee.repositories.TicketRepository;

public class TicketServiceimpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public Ticket findTicket(String nomClient) {
		Ticket ticket = ticketRepository.findByNomClient(nomClient);
		if(ticket == null)
			throw new EntityNotFoundException("No ticket of "+nomClient+" is founded");
		else
			return ticket;
	}

	@Override
	public List<Ticket> findReservedTicket(boolean reservee, int page, int limit) {
		Pageable pageable =  PageRequest.of(page, limit);
		Page<Ticket> tickets = ticketRepository.findByReservee(reservee,pageable);
		if(tickets == null)
			return new ArrayList<Ticket>();
		else
			return tickets.toList();
	}

	@Override
	public Ticket updateTicket(Long id, Ticket ticket) {
		Optional<Ticket> ticketR = ticketRepository.findById(id);
		
		if(ticketR == null)
			throw new EntityNotFoundException("No ticket with id "+id+" is founded");
		else {
			ticket.setId(id);
			//ticketRepository.delete(ticketR);
			ticketRepository.save(ticket);
			return ticket;
		}
			
	}

	@Override
	public void deleteTicket(Long id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
	
		if(ticket == null)
			throw new EntityNotFoundException("No ticket with id "+id+" is founded");
		else
			ticketRepository.delete(ticket.get());
	}

}