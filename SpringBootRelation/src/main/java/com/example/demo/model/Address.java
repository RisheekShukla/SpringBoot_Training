package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="Addressdata")
public class Address {
	@Id
	@Column(name="addressid")
	private int addressid;
	@Column(name="houseno")
	private String houseno;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@OneToOne(mappedBy="addobj")
	private Student sobj;
	public Student getSobj() {
		return sobj;
	}
	public void setSobj(Student sobj) {
		this.sobj = sobj;
	}
	
}
