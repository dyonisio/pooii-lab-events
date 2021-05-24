package com.facens.pooii.lab.ac1.ac1.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlaceInsertDTO {
    @NotNull(message = "Nome do lugar é obrigatório")
    @NotBlank(message = "Nome do lugar não pode estar em branco")
    private String name;
    @NotNull(message = "Endereço é obrigatório")
    @NotBlank(message = "Endereço não pode estar em branco")
    private String address;
    
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
    
   
