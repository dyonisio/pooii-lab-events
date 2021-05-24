package com.facens.pooii.lab.ac1.ac1.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.facens.pooii.lab.ac1.ac1.dtos.AdminInsertDTO;

@Entity
@Table(name="TB_ADMIN")
@PrimaryKeyJoinColumn(name="BASE_USER_ID")
public class Admin extends BaseUser{
    private String phoneNumber;

    @OneToMany(mappedBy = "admin")
    private List<Event> events = new ArrayList<>();

    public Admin(){
        
    }

    public Admin(AdminInsertDTO dto) {
        super(dto.getName(), dto.getEmail());
        this.phoneNumber = dto.getPhoneNumber();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
