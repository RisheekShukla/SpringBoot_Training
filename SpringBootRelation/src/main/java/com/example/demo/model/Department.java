package com.example.demo.model;

import jakarta.persistence.CascadeType;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="DepartmentRel")
public class Department {
	@Id
	@Column(name="departmentcode")
	private int deptcode;
	@Column(name="deptname")
	private String deptname;
	@Column(name="city")
	private String city;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="departmentcode")
	private List<Employee>emplist;
	public int getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(int deptcode) {
		this.deptcode = deptcode;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
}
