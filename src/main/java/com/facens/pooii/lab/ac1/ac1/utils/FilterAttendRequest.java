package com.facens.pooii.lab.ac1.ac1.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FilterAttendRequest {
    private String name;
	private String email;
	private double balance;

	public FilterAttendRequest(){}

    public FilterAttendRequest(String name, String email, String balance) {
		this.name = name;
		this.email = email;
		try {
            this.balance = Double.parseDouble(balance);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid balance, please use only numbers");
        }
	}

	public static FilterAttendRequest of(String name, String email, String balance) {
		return new FilterAttendRequest(name, email, balance);
	}

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
