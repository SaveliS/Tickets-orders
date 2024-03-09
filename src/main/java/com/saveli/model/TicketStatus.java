package com.saveli.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ticketstatus")
public class TicketStatus {
    @Id
    @Column("idstatustickets")
    private int idStatusTicket;
    @Column("name")
    private String name;
    @Column("description")
    private String description;

    public TicketStatus(){

    }

    public TicketStatus(int idStatusTicket, String name, String description){
        this.description = description;
        this.idStatusTicket = idStatusTicket;
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdStatusTicket(int idStatusTicket) {
        this.idStatusTicket = idStatusTicket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public int getIdStatusTicket() {
        return idStatusTicket;
    }

    public String getName() {
        return name;
    }
}
