package com.BookHall.Hall.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HallInformation")
public class HallInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hallid")
	private int hallid;
	
	@Column(name="hallname", nullable=false)
	private String hallname;
	
	@Column(name="muncipal_regNum", nullable=false)
	private String muncipal_regestrationNumber;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="address_locality", nullable=false)
	private String address_locality;
	
	@Column(name="address_city", nullable=false)
	private String address_city;

	@Column(name="address_state", nullable=false)
	private String address_state;
	
	@Column(name="address_country", nullable=false)
	private String address_country;
	
	@Column(name="address_pincode", nullable=false)
	private String address_pincode;

	@Column(name="advance_amount", nullable=false)
	private int advance_amount;

	@Column(name="amount", nullable=false)
	private int amount;
	
	@Column(name="hall_capacity", nullable=false)
	private int hall_capacity;

//	@OneToMany(mappedBy="HallInformation")
//	private List<Services> services;
	
	public int getHallid() {
		return hallid;
	}

	public void setHallid(int hallid) {
		this.hallid = hallid;
	}

	public String getHallname() {
		return hallname;
	}

	public void setHallname(String hallname) {
		this.hallname = hallname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress_locality() {
		return address_locality;
	}

	public void setAddress_locality(String address_locality) {
		this.address_locality = address_locality;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_state() {
		return address_state;
	}

	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}

	public String getAddress_country() {
		return address_country;
	}

	public void setAddress_country(String address_country) {
		this.address_country = address_country;
	}

	public String getAddress_pincode() {
		return address_pincode;
	}

	public void setAddress_pincode(String address_pincode) {
		this.address_pincode = address_pincode;
	}

	public int getAdvance_amount() {
		return advance_amount;
	}

	public void setAdvance_amount(int advance_amount) {
		this.advance_amount = advance_amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getHall_capacity() {
		return hall_capacity;
	}

	public void setHall_capacity(int hall_capacity) {
		this.hall_capacity = hall_capacity;
	}

	public String getMuncipal_regestrationNumber() {
		return muncipal_regestrationNumber;
	}

	public void setMuncipal_regestrationNumber(String muncipal_regestrationNumber) {
		this.muncipal_regestrationNumber = muncipal_regestrationNumber;
	}
	
}

