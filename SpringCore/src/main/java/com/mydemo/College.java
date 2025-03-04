package com.mydemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class College {
	private int collegecode;
	private String collegename;
	private String city;
	
	@Autowired    // search for all student object in config file 
	// will inject here
//	@Qualifier("student2") // only for 1 stu
	private List<Student> stulist;
	public List<Student> getStulist() {
		return stulist;
	}
	public void setStulist(List<Student> stulist) {
		this.stulist = stulist;
	}
	public int getCollegecode() {
		return collegecode;
	}
	public void setCollegecode(int collegecode) {
		this.collegecode = collegecode;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
