package com.saveli.model;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("event")
public class Event {
    @Id
    @Column("idevent")
    private int idEvent;
    @Column("dateevent")
    private Date dateEvent;
    @Column("nameevent")
    private String nameEvent;
    @Column("typeevent")
    private TypeEvent typeEvent;
    @Column("ticketsbeginsales")
    private Date ticketsBeginSales;
    @Column("ticketsendsales")
    private Date ticketsEndSales;
    @Column("maxnumberpayer")
    private int maxNumberPayer;
    @Column("availabletickets")
    private int availableTickets;
    @Column("remainingseats")
    private int remainingSeats;
    @Column("placeevent")
    private final Place placeEvent;

    @Autowired
    public Event(Place placeEvent){
        this.placeEvent = placeEvent;
    }

    public Event(int idEvent, Date dateEvent, String nameEvent, TypeEvent typeEvent, Date ticketsBeginSales,
            Date ticketsEndSales, int maxNumberPayer, int availableTickets, int remainingSeats, Place placeEvent) {
        this.idEvent = idEvent;
        this.dateEvent = dateEvent;
        this.nameEvent = nameEvent;
        this.typeEvent = typeEvent;
        this.ticketsBeginSales = ticketsBeginSales;
        this.ticketsEndSales = ticketsEndSales;
        this.maxNumberPayer = maxNumberPayer;
        this.availableTickets = availableTickets;
        this.remainingSeats = remainingSeats;
        this.placeEvent = placeEvent;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public Date getDateEvent() {
        return dateEvent;
    }
    
    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public TypeEvent getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(TypeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }

    public Date getTicketsBeginSales() {
        return ticketsBeginSales;
    }

    public void setTicketsBeginSales(Date ticketsBeginSales) {
        this.ticketsBeginSales = ticketsBeginSales;
    }

    public Date getTicketsEndSales() {
        return ticketsEndSales;
    }

    public void setTicketsEndSales(Date ticketsEndSales) {
        this.ticketsEndSales = ticketsEndSales;
    }

    public int getMaxNumberPayer() {
        return maxNumberPayer;
    }

    public void setMaxNumberPayer(int maxNumberPayer) {
        this.maxNumberPayer = maxNumberPayer;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public Place getPlaceEvent() {
        return placeEvent;
    }
}
