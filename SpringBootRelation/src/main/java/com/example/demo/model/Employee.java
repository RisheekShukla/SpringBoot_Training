package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name="EmployeeRel")
public class Employee 
{
	@Id
	@Column(name="empid")
	private int empid;
//	@Column(name="empname")
	private String empname;
//	@Column(name="salary")
	private double salary;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
