package com.facens.pooii.lab.ac1.ac1.utils;

import java.time.LocalDate;

public class FilterRequest {
    private String name;
	private String place;
	private LocalDate startDate;
	private String description;

	public FilterRequest(){}

    public FilterRequest(String name, String place, String startDate, String description) {
		this.name = name;
		this.place = place;
		this.startDate = LocalDate.parse(startDate);
		this.description = description;
	}

	public static FilterRequest of(String name, String place, String startDate, String description) {
		return new FilterRequest(name, place, startDate, description);
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

	
}
