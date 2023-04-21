package com.TTS.ServiceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TTS.Entity.Ticket;
import com.TTS.Repository.TicketRepository;
import com.TTS.Service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}
	
	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		ticket.setTicketCreatedOn(LocalDate.now());
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).get();	}

	@Override
	public List<Ticket> findByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		ticket.setTicketUpdatedOn(LocalDate.now());
		return ticketRepository.save(ticket);

	}

	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.deleteById(id);

	}

}
