package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="studentrelation")
public class Student {
	@Id
	@Column(name="studentid")
	private int studentid;
	@Column(name="studentname")
	private String studentname;
	@Column(name="city")
	private String city;
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
	@JoinColumn(name="addressid")
	private Address addobj;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address getAddobj() {
		return addobj;
	}
	public void setAddobj(Address addobj) {
		this.addobj = addobj;
	}
	
}
