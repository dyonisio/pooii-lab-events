package com.facens.pooii.lab.ac1.ac1.dtos;

import com.facens.pooii.lab.ac1.ac1.entities.Attend;

public class AttendListDTO {
    private Long id;
    private String name;
    private String email;
    private Double balance = 0d;

    public AttendListDTO(Long id, String name, String email, Double balance){
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public AttendListDTO(Attend attend) {
        this.id = attend.getId();
        this.name = attend.getName();
        this.email = attend.getEmail();
        this.balance = attend.getBalance();
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
}
