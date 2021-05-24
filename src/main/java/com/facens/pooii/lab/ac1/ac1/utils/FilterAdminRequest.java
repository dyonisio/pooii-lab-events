package com.facens.pooii.lab.ac1.ac1.utils;

public class FilterAdminRequest {
    private String name;
	private String email;
	private String phoneNumber;
	public FilterAdminRequest(){}

    public FilterAdminRequest(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public static FilterAdminRequest of(String name, String email, String phoneNumber) {
		return new FilterAdminRequest(name, email, phoneNumber);
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
