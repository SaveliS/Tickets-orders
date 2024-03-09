package com.saveli.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("tickets")
public class Ticket {
    @Id
    @Column("numbertickets")
    private int numberTickets;
    @Column("datecreateticket")
    private Date dateCreateTicket;
    @Column("statustikects")
    private TicketStatus ticketStatus;
    @Column("priceticket")
    private double priceTicket;
    @Column("idevent")
    private final Event event;

    @Autowired
    public Ticket(Event event){
        this.event = event;
    }

    public Ticket(int numberTickets, Date dateCreateTicket, TicketStatus ticketStatus, double priceTicket,
            Event event) {
        this.numberTickets = numberTickets;
        this.dateCreateTicket = dateCreateTicket;
        this.ticketStatus = ticketStatus;
        this.priceTicket = priceTicket;
        this.event = event;
    }

    public int getNumberTickets() {
        return numberTickets;
    }

    public Date getDateCreateTicket() {
        return dateCreateTicket;
    }

    public void setDateCreateTicket(Date dateCreateTicket) {
        this.dateCreateTicket = dateCreateTicket;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Event getEvent() {
        return event;
    }

    public void setNumberTickets(int numberTickets) {
        this.numberTickets = numberTickets;
    }
}
