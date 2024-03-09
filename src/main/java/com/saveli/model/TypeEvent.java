package com.saveli.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("typeevent")
public class TypeEvent {
    @Id
    @Column("idtypeevent")
    private int idTypeEvent;
    @Column("name")
    private String name;

    public TypeEvent(){

    }

    public TypeEvent(String name, int idTypeEvent){
        this.idTypeEvent = idTypeEvent;
        this.name = name;
    }

    public int getIdTypeEvent() {
        return idTypeEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdTypeEvent(int idTypeEvent) {
        this.idTypeEvent = idTypeEvent;
    }
}
