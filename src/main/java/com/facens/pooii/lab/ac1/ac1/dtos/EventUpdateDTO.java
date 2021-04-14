package com.facens.pooii.lab.ac1.ac1.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EventUpdateDTO {
    @NotNull(message = "Descrição é obrigatório")
    @NotBlank(message = "Descrição não pode estar em branco")
    private String description;
    @NotNull(message = "Lugar é obrigatório")
    @NotBlank(message = "Place não pode estar em branco")
    private String place;
    @NotNull(message = "Data de Inicio é obrigatório")
    private LocalDate startDate;
    @NotNull(message = "Data de Fim é obrigatório")
    private LocalDate endDate;
    @NotNull(message = "Tempo do Inicio é obrigatório")
    private LocalTime startTime;
    @NotNull(message = "Tempo de Fim é obrigatório")
    private LocalTime endTime;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
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
}
