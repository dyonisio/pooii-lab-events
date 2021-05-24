package com.facens.pooii.lab.ac1.ac1.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EventUpdateDTO {
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
    @NotNull(message = "É necessário informar o tickets de graça disponíveis")
    private Long amountFreeTickets;
    @NotNull(message = "É necessário informar o tickets pagos disponíveis")
    private Long amountPayedTickets;
    @NotNull(message = "É necessário informar o preço dos tickets")
    private Double priceTicket;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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
