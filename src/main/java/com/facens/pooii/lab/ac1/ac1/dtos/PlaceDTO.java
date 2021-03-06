package com.facens.pooii.lab.ac1.ac1.dtos;

import java.util.ArrayList;
import java.util.List;

import com.facens.pooii.lab.ac1.ac1.entities.Event;
import com.facens.pooii.lab.ac1.ac1.entities.Place;

public class PlaceDTO {
    private Long id;
    private String name;
    private String address;
    private List<EventListDTO> events = new ArrayList<>();

    public PlaceDTO(){

    }

    public PlaceDTO(Long id, String name, String address, List<Event> events) {
        this.id = id;
        this.name = name;
        this.address = address;
        for (Event event : events) {
            this.events.add(new EventListDTO(event));
        };
    }

    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.address = place.getAddress();
        for (Event event : place.getEvents()) {
            this.events.add(new EventListDTO(event));
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<EventListDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventListDTO> events) {
        this.events = events;
    }
}
