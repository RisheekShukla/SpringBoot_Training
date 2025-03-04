package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name="Bookdata")
public class Book {
	@Id
	@Column(name="bookid")
	private int bookid;
	@Column(name="bookname")
	private String bookname;
	@Column(name="price")
	private double price;
	@Column(name="quantity")
	private int quantity;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
