package com.facens.pooii.lab.ac1.ac1.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EventInsertDTO {
    @NotNull(message = "Nome é obrigatório")
    @NotBlank(message = "Nome não pode estar em branco")
    private String name;
    @NotNull(message = "Descrição é obrigatório")
    @NotBlank(message = "Descrição não pode estar em branco")
    private String description;
    @NotNull(message = "Data de Inicio é obrigatório")
    private LocalDate startDate;
    @NotNull(message = "Data de Fim é obrigatório")
    private LocalDate endDate;
    @NotNull(message = "Tempo do Inicio é obrigatório")
    private LocalTime startTime;
    @NotNull(message = "Tempo de Fim é obrigatório")
    private LocalTime endTime;
    @NotNull(message = "Email contato é obrigatório")
    @NotBlank(message = "Email de contato não pode estar em branco")
    private String emailContact;
    @NotNull(message = "É necessário informar o tickets de graça disponíveis")
    private Long amountFreeTickets;
    @NotNull(message = "É necessário informar o tickets pagos disponíveis")
    private Long amountPayedTickets;
    @NotNull(message = "É necessário informar o preço dos tickets")
    private Double priceTicket;
    @NotNull(message = "É necessário passar o ID de um admin")
    private Long idAdmin;

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
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        try {
            this.startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format, please insert date pattern (yyyy-MM-dd)");
        }
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
    public Long getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(Long id_Admin) {
        this.idAdmin = id_Admin;
    }
    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }
    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }
    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }
    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }
    public Double getPriceTicket() {
        return priceTicket;
    }
    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }
    
}
