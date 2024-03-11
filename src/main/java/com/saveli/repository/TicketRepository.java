package com.saveli.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.saveli.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket,Integer>{
    List<Ticket> findAll();
}
