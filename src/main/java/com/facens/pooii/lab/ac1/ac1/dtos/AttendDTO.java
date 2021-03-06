package com.facens.pooii.lab.ac1.ac1.dtos;

import java.util.ArrayList;
import java.util.List;

import com.facens.pooii.lab.ac1.ac1.entities.Attend;
import com.facens.pooii.lab.ac1.ac1.entities.Ticket;

public class AttendDTO {
    private Long id;
    private String name;
    private String email;
    private Double balance = 0d;
    private List<TicketListDTO> tickets = new ArrayList<>();

    public AttendDTO(Long id, String name, String email, Double balance, List<Ticket> tickets){
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
        for (Ticket ticket : tickets) {
            this.tickets.add(new TicketListDTO(ticket));
        };
    }

    public AttendDTO(Attend attend) {
        this.id = attend.getId();
        this.name = attend.getName();
        this.email = attend.getEmail();
        this.balance = attend.getBalance();
        for (Ticket ticket : attend.getTickets()) {
            this.tickets.add(new TicketListDTO(ticket));
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<TicketListDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketListDTO> tickets) {
        this.tickets = tickets;
    }
}
