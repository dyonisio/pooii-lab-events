package com.facens.pooii.lab.ac1.ac1.utils;

public class FilterPlaceRequest {
    private String name;
	private String address;
	public FilterPlaceRequest(){}

    public FilterPlaceRequest(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public static FilterPlaceRequest of(String name, String address) {
		return new FilterPlaceRequest(name, address);
	}

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
