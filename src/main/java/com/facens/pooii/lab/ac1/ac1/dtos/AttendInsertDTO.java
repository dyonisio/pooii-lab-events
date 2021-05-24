package com.facens.pooii.lab.ac1.ac1.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AttendInsertDTO {
    @NotNull(message = "Nome é obrigatório")
    @NotBlank(message = "Nome não pode estar em branco")
    private String name;
    @NotNull(message = "Email é obrigatório")
    @NotBlank(message = "Email não pode estar em branco")
    private String email;
    private Double balance = 0d;

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
