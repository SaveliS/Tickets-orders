package com.saveli.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("place")
public class Place {
    @Id
    @Column("id_place")
    private int id_place;
    @Column("nameplace")
    private String namePlase;
    @Column("numberseats")
    private int numberSeats;
    @Column("couterrow")
    private int couterRow;
    @Column("seatsinrow")
    private int seatsInRow; // Кол-во мест на площадке.
    
    public Place(){

    }

    public Place(int id_place,String namePlase, int numberSeats, int couterRow, int seatsInRow){
        this.id_place = id_place;
        this.namePlase = namePlase;
        this.numberSeats = numberSeats;
        this.couterRow = couterRow;
        this.seatsInRow = seatsInRow;
    }

    public int getCouterRow() {
        return couterRow;
    }

    public int getId_place() {
        return id_place;
    }

    public String getNamePlase() {
        return namePlase;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }

    public void setCouterRow(int couterRow) {
        this.couterRow = couterRow;
    }

    public void setNamePlase(String namePlase) {
        this.namePlase = namePlase;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }
    
    public void setSeatsInRow(int seatsInRow) {
        this.seatsInRow = seatsInRow;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }
}
