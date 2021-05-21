package com.kouhou.jee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.TicketService;
import com.kouhou.jee.entities.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@GetMapping(path="/{clientName}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Ticket> getTicket(@PathVariable String clientName) {
		Ticket ticket = ticketService.findTicket(clientName);
		return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Ticket>> getByReserve(@RequestParam boolean reservee,@RequestParam int page, @RequestParam int limit){
		List<Ticket> tickets = ticketService.findReservedTicket(reservee, page, limit);
		return new ResponseEntity<List<Ticket>>(tickets,HttpStatus.OK);
	}
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Ticket>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Ticket> tickets = ticketService.findAll(page, limit);
		return new ResponseEntity<List<Ticket>>(tickets,HttpStatus.OK);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
		Ticket ticketR = ticketService.addTicket(ticket);
		return new ResponseEntity<Ticket>(ticket,HttpStatus.ACCEPTED);
	}
	@PutMapping(path = "/edit/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket){
		Ticket ticketR = ticketService.updateTicket(id, ticket);
		return new ResponseEntity<Ticket>(ticketR,HttpStatus.ACCEPTED);
	}
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Ticket> deleteTicket(@PathVariable Long id){
		ticketService.deleteTicket(id);
		return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
	}
	
}
