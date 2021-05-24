package com.facens.pooii.lab.ac1.ac1.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilterEventRequest {
    private String name;
	private String place;
	private LocalDate startDate;
	private Double priceTicket;
	private String description;

	public FilterEventRequest(){}

    public FilterEventRequest(String name, String startDate, String description, String priceTicket) {
		this.name = name;
		try {
            this.startDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			this.priceTicket = Double.parseDouble(priceTicket);
        } catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Por favor, insira somente números");
		} catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format, please insert date pattern (yyyy-MM-dd)");
        }

		this.priceTicket = Double.parseDouble(priceTicket);
		this.startDate = LocalDate.parse(startDate);
		this.description = description;
	}

	public static FilterEventRequest of(String name, String startDate, String description, String priceTicket) {
		return new FilterEventRequest(name, startDate, description, priceTicket);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPriceTicket() {
		return priceTicket;
	}

	public void setPriceTicket(Double priceTicket) {
		this.priceTicket = priceTicket;
	}
}
