package com.TTS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketTrackerApplication.class, args);
		
		System.out.println("\n\n Welcome to Ticket Tracker Application");
		
		System.out.println("\n\n Use URL as localhost:<PORT>/tickets/welcome");
		
		System.out.println("");
		
	}

}
