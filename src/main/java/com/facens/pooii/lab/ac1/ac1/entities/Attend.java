package com.facens.pooii.lab.ac1.ac1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.facens.pooii.lab.ac1.ac1.dtos.AttendInsertDTO;

@Entity
@Table(name="TB_ATTEND")
@PrimaryKeyJoinColumn(name="BASE_USER_ID")
public class Attend extends BaseUser{
    private Double balance = 0d;

    @OneToMany(mappedBy = "attend")
    private List<Ticket> tickets = new ArrayList<>();

    public Attend(){

    }

    public Attend(AttendInsertDTO dto) {
        super(dto.getName(), dto.getEmail());
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void removeTicket(Ticket ticket){
        tickets.remove(ticket);
    }

    public List<Ticket> getTickets(){
        return tickets;
    }    
}
