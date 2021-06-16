package com.facens.pooii.lab.ac1.ac1.dtos;
import java.time.Instant;

import com.facens.pooii.lab.ac1.ac1.entities.Ticket;
import com.facens.pooii.lab.ac1.ac1.utils.TicketType;

public class TicketListDTO {
    private Long id;
    private TicketType.ticketType type;
    private Instant date;
    private Double price;

    public TicketListDTO(){

    }

    public TicketListDTO(Ticket ticket) {
        this.id = ticket.getId();
        this.type = ticket.getType();
        this.date = ticket.getDate();
        this.price = ticket.getPrice();
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

    
}
