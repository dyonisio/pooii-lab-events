package com.facens.pooii.lab.ac1.ac1.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.facens.pooii.lab.ac1.ac1.utils.TicketType;

@Entity
@Table(name="TB_TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TicketType.ticketType type;
    private Instant date;
    private Double price;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Attend attend;

    public Ticket() {

    }

    public Ticket(Event event, Attend attend, TicketType.ticketType type, Double price, Instant date) {
        this.event = event;
        this.attend = attend;
        this.price = price;
        this.date = date;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketType.ticketType getType() {
        return type;
    }

    public void setType(TicketType.ticketType type) {
        this.type = type;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Attend getAttend() {
        return attend;
    }

    public void setAttend(Attend attend) {
        this.attend = attend;
    }   
    
    


}
