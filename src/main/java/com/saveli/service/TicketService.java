package com.saveli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveli.model.Ticket;
import com.saveli.repository.TicketRepository;

@Service
public class TicketService {
    
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Iterable<Ticket> getAllTicket(){
        return ticketRepository.findAll();
    }
}
