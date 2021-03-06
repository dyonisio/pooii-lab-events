package com.facens.pooii.lab.ac1.ac1.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.facens.pooii.lab.ac1.ac1.entities.Admin;
import com.facens.pooii.lab.ac1.ac1.entities.Event;
import com.facens.pooii.lab.ac1.ac1.entities.Place;
import com.facens.pooii.lab.ac1.ac1.entities.Ticket;

public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String emailContact;
    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Long freeTicketsSelled;
    private Long payedTicketsSelled;
    private Double priceTicket;
    private Admin admin = new Admin();
    private List<PlaceListDTO> places = new ArrayList<>();
    private List<TicketListDTO> tickets = new ArrayList<>(){};

    public EventDTO(){

    }

    public EventDTO(Long id, String name, String description, LocalDate startDate,
            LocalDate endDate, LocalTime startTime, LocalTime endTime, String emailContact, Long amountFreeTickets,
            Long amoundPayedTickets, Double priceTicket, Long freeTicketsSelled, Long payedTicketsSelled, List<Place> places, List<Ticket> tickets) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.startDate = startDate;
                this.endDate = endDate;
                this.startTime = startTime;
                this.endTime = endTime;
                this.emailContact = emailContact;
                this.freeTicketsSelled = freeTicketsSelled;
                this.payedTicketsSelled = payedTicketsSelled;
                for (Place place : places) {
                    this.places.add(new PlaceListDTO(place));
                };
                for (Ticket ticket : tickets){
                    this.tickets.add(new TicketListDTO(ticket));
                };
    }
    
    public EventDTO(Event eve) {
        this.id = eve.getId();
        this.name = eve.getName();
        this.description = eve.getDescription();
        this.startDate = eve.getStartDate();
        this.endDate = eve.getEndDate();
        this.startTime = eve.getStartTime();
        this.endTime = eve.getEndTime();
        this.emailContact = eve.getEmailContact();
        this.amountFreeTickets = eve.getAmountFreeTickets();
        this.amountPayedTickets = eve.getAmountPayedTickets();
        this.priceTicket = eve.getPriceTicket();
        this.freeTicketsSelled = eve.getFreeTicketsSelled();
        this.payedTicketsSelled = eve.getPayedTicketsSelled();
        this.admin = eve.getAdmin();
        for (Place place : eve.getPlaces()) {
            this.places.add(new PlaceListDTO(place));
        };
        for (Ticket ticket : eve.getTickets()){
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public String getEmailContact() {
        return emailContact;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
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

    public void setAmountPayedTickets(Long amountPayedTickes) {
        this.amountPayedTickets = amountPayedTickes;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<PlaceListDTO> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceListDTO> places) {
        this.places = places;
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

    public List<TicketListDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketListDTO> tickets) {
        this.tickets = tickets;
    }    
}
