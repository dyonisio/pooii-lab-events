package com.facens.pooii.lab.ac1.ac1.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AdminUpdateDTO {
    @NotNull(message = "Nome é obrigatório")
    @NotBlank(message = "Nome não pode estar em branco")
    private String name;
    @NotNull(message = "Email é obrigatório")
    @NotBlank(message = "Email não pode estar em branco")
    private String email;
    @NotNull(message = "Numero de telefone é obrigatório")
    @NotBlank(message = "Numero de telefone não pode estar em branco")
    private String phoneNumber;
    
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
