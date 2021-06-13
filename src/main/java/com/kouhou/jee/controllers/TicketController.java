<<<<<<< HEAD
package com.kouhou.jee.controllers;

import java.util.ArrayList;
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
import com.kouhou.jee.response.TicketResponse;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@GetMapping(path="/{clientName}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String clientName) {
		Ticket ticket = ticketService.findTicket(clientName);
		return new ResponseEntity<TicketResponse>(ticket.map(),HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TicketResponse>> getByReserve(@RequestParam boolean reservee,@RequestParam int page, @RequestParam int limit){
		List<Ticket> tickets = ticketService.findReservedTicket(reservee, page, limit);
		List<TicketResponse> ticketRs = new ArrayList<TicketResponse>();
		for(Ticket ticket : tickets)
			ticketRs.add(ticket.map());
		return new ResponseEntity<List<TicketResponse>>(ticketRs,HttpStatus.OK);
	}
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TicketResponse>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Ticket> tickets = ticketService.findAll(page, limit);
		List<TicketResponse> ticketRs = new ArrayList<TicketResponse>();
		for(Ticket ticket : tickets)
			ticketRs.add(ticket.map());
		return new ResponseEntity<List<TicketResponse>>(ticketRs,HttpStatus.OK);
	}
	
	@PostMapping(path="/add",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TicketResponse> addTicket(@RequestBody Ticket ticket) {
		Ticket ticketR = ticketService.addTicket(ticket);
		return new ResponseEntity<TicketResponse>(ticket.map(),HttpStatus.ACCEPTED);
	}
	@PutMapping(path = "/edit/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TicketResponse> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket){
		Ticket ticketR = ticketService.updateTicket(id, ticket);
		return new ResponseEntity<TicketResponse>(ticketR.map(),HttpStatus.ACCEPTED);
	}
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<TicketResponse> deleteTicket(@PathVariable Long id){
		ticketService.deleteTicket(id);
		return new ResponseEntity<TicketResponse>(HttpStatus.NO_CONTENT);
	}
	
}
=======
package com.kouhou.jee.controllers;

import java.util.ArrayList;
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
import com.kouhou.jee.response.TicketResponse;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	@GetMapping(path="/{clientName}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String clientName) {
		Ticket ticket = ticketService.findTicket(clientName);
		return new ResponseEntity<TicketResponse>(ticket.map(),HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TicketResponse>> getByReserve(@RequestParam boolean reservee,@RequestParam int page, @RequestParam int limit){
		List<Ticket> tickets = ticketService.findReservedTicket(reservee, page, limit);
		List<TicketResponse> ticketRs = new ArrayList<TicketResponse>();
		for(Ticket ticket : tickets)
			ticketRs.add(ticket.map());
		return new ResponseEntity<List<TicketResponse>>(ticketRs,HttpStatus.OK);
	}
	@GetMapping(path="/all",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<TicketResponse>> getAll(@RequestParam int page, @RequestParam int limit){
		List<Ticket> tickets = ticketService.findAll(page, limit);
		List<TicketResponse> ticketRs = new ArrayList<TicketResponse>();
		for(Ticket ticket : tickets)
			ticketRs.add(ticket.map());
		return new ResponseEntity<List<TicketResponse>>(ticketRs,HttpStatus.OK);
	}
	
	@PostMapping(path="/add",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TicketResponse> addTicket(@RequestBody Ticket ticket) {
		Ticket ticketR = ticketService.addTicket(ticket);
		return new ResponseEntity<TicketResponse>(ticket.map(),HttpStatus.ACCEPTED);
	}
	@PutMapping(path = "/edit/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TicketResponse> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket){
		Ticket ticketR = ticketService.updateTicket(id, ticket);
		return new ResponseEntity<TicketResponse>(ticketR.map(),HttpStatus.ACCEPTED);
	}
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<TicketResponse> deleteTicket(@PathVariable Long id){
		ticketService.deleteTicket(id);
		return new ResponseEntity<TicketResponse>(HttpStatus.NO_CONTENT);
	}
	
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
