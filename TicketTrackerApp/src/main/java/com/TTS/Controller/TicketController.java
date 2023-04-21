package com.TTS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TTS.Entity.Ticket;
import com.TTS.Service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	
	@GetMapping("/welcome")
	public String sayHello(Model model) {
		return "hello";
	}
	
	// handler method to handle list tickets and return mode and view
	@GetMapping("/list")
	public String listtickets(Model model) {
		model.addAttribute("tickets", ticketService.getAllTickets());
		model.addAttribute("header", "List Tickets");
		return "ticketRecords";
	}

	@GetMapping("/showFormForAdd")
	public String createticketForm(Model model) {

		// create ticket object to hold ticket form data
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "createTicketPage";

	}

	@PostMapping("/list")
	public String saveTickets(@ModelAttribute("ticket") Ticket ticket) {

		ticketService.saveTicket(ticket);

		return "redirect:/tickets/list";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateticketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "editTicketPage";
	}
	
	@GetMapping("/search")
	public String searchTicket(Ticket ticket,Model model,String keyword) {
		List<Ticket> list = ticketService.findByKeyword(keyword);
		model.addAttribute("tickets", list);
		model.addAttribute("keyword", keyword);
		model.addAttribute("header", "Search Results");
		return "ticketRecords";
	}
	
	@PostMapping("/{id}")
	public String updatetickets(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {

		// get ticket from database by no
		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setTicketTitle(ticket.getTicketTitle());
		existingTicket.setTicketShortDescription(ticket.getTicketShortDescription());
		existingTicket.setTicketContent(ticket.getTicketContent());

		// save updated ticket object
		ticketService.updateTicket(existingTicket);
		return "redirect:/tickets/list";
	}

	// handler method to handle delete ticket request

	@GetMapping("/{id}")
	public String viewticket(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "viewTicketPage";
	}

	@GetMapping("/delete/{id}")
	public String deleteticket(@PathVariable Long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets/list";
	}

}
