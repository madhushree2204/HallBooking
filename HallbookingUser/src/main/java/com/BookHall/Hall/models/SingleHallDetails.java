package com.BookHall.Hall.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SingleHallDetails {

	private String hallName;
	private String description;
	private String locality;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private int advanceAmout;
	private int amount;
	private int hallCapacity;
	private List<Services> services;
	
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getAdvanceAmout() {
		return advanceAmout;
	}
	public void setAdvanceAmout(int advanceAmout) {
		this.advanceAmout = advanceAmout;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getHallCapacity() {
		return hallCapacity;
	}
	public void setHallCapacity(int hallCapacity) {
		this.hallCapacity = hallCapacity;
	}
	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	}
	
}
