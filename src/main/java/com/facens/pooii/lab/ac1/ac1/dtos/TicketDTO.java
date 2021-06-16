package com.facens.pooii.lab.ac1.ac1.dtos;
import java.util.ArrayList;
import java.util.List;

import com.facens.pooii.lab.ac1.ac1.entities.Event;

import com.facens.pooii.lab.ac1.ac1.utils.TicketType.ticketType;

public class TicketDTO {
    private List<TicketIndividualDTO> tickets = new ArrayList<>();
    private String name;
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Long freeTicketsSelled = 0l;
    private Long payedTicketsSelled = 0l;

    public TicketDTO(){

    }

    public TicketDTO(Event event) {
        this.amountFreeTickets = event.getAmountFreeTickets();
        this.amountPayedTickets = event.getAmountPayedTickets();
        this.freeTicketsSelled = event.getFreeTicketsSelled();
        this.payedTicketsSelled = event.getPayedTicketsSelled();
        this.name = event.getName();
        this.tickets.add(new TicketIndividualDTO(ticketType.FREE, event.getTickets())); 
        this.tickets.add(new TicketIndividualDTO(ticketType.PAYED, event.getTickets())); 
    }

    public List<TicketIndividualDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketIndividualDTO> tickets) {
        this.tickets = tickets;
    }

    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }

    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }

    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }

    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }

    public Long getFreeTicketsSelled() {
        return freeTicketsSelled;
    }

    public void setFreeTicketsSelled(Long freeTicketsSelled) {
        this.freeTicketsSelled = freeTicketsSelled;
    }

    public Long getPayedTicketsSelled() {
        return payedTicketsSelled;
    }

    public void setPayedTicketsSelled(Long payedTicketsSelled) {
        this.payedTicketsSelled = payedTicketsSelled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}
