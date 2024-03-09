package com.saveli.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saveli.model.Event;
import com.saveli.model.Ticket;
import com.saveli.model.TicketStatus;
import com.saveli.repository.TicketRepository;

@Service
public class TicketService {
    
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public Iterable<Ticket> getAllTicket(){
        return ticketRepository.findAll();
    }

    public List<Ticket> getByEvent(Event event){
        return ticketRepository.findByEvent(event);
    }

    public List<Ticket> getByTicketStatus(TicketStatus ticketStatus){
        return ticketRepository.findByTicketStatus(ticketStatus);
    }
}
