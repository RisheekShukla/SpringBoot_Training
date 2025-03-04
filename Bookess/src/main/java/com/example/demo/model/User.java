package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="UserTable")
public class User {
	@Id
	@Column(name="userCode")
	private int usercode;
	private String username;
	private String password;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="userCode")
	private List<Movie>mlist;
	public List<Movie> getMlist() {
		return mlist;
	}
	public void setMlist(List<Movie> mlist) {
		this.mlist = mlist;
	}
	public int getUsercode() {
		return usercode;
	}
	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
