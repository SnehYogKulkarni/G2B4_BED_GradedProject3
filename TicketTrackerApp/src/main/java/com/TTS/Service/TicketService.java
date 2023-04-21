package com.TTS.Service;

import java.util.List;

import com.TTS.Entity.Ticket;

public interface TicketService {

	List<Ticket> getAllTickets();

	Ticket saveTicket(Ticket ticket);

	Ticket getTicketById(Long id);

	List<Ticket> findByKeyword(String keyword);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);
}
