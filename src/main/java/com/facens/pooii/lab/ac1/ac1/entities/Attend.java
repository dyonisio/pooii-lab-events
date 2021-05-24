package com.facens.pooii.lab.ac1.ac1.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.facens.pooii.lab.ac1.ac1.dtos.AttendInsertDTO;

@Entity
@Table(name="TB_ATTEND")
@PrimaryKeyJoinColumn(name="BASE_USER_ID")
public class Attend extends BaseUser{
    private Double balance;

    public Attend(){

    }

    public Attend(AttendInsertDTO dto) {
        super(dto.getName(), dto.getEmail());
        this.balance = dto.getBalance();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
