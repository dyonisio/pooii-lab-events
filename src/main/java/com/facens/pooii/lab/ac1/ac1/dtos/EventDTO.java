package com.facens.pooii.lab.ac1.ac1.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.facens.pooii.lab.ac1.ac1.entities.Event;

public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String emailContact;

    public EventDTO(){

    }

    public EventDTO(Long id, String name, String description, String place, LocalDate startDate,
            LocalDate endDate, LocalTime startTime, LocalTime endTime, String emailContact) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.place = place;
                this.startDate = startDate;
                this.endDate = endDate;
                this.startTime = startTime;
                this.endTime = endTime;
                this.emailContact = emailContact;
    }
    
    public EventDTO(Event eve) {
        this.id = eve.getId();
        this.name = eve.getName();
        this.description = eve.getDescription();
        this.place = eve.getPlace();
        this.startDate = eve.getStartDate();
        this.endDate = eve.getEndDate();
        this.startTime = eve.getStartTime();
        this.endTime = eve.getEndTime();
        this.emailContact = eve.getEmailContact();
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
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
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
}
