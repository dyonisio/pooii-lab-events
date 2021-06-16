package com.facens.pooii.lab.ac1.ac1.dtos;
import com.facens.pooii.lab.ac1.ac1.entities.Place;

public class PlaceListDTO {
    private Long id;
    private String name;
    private String address;

    public PlaceListDTO(){

    }

    public PlaceListDTO(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public PlaceListDTO(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.address = place.getAddress();
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
}
