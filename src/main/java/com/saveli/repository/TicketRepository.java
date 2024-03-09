package com.saveli.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saveli.model.Event;
import com.saveli.model.Ticket;
import com.saveli.model.TicketStatus;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Integer>{
    List<Ticket> findAll();
    List<Ticket> findByEvent(Event event);
    List<Ticket> findByTicketStatus(TicketStatus ticketStatus);
}
