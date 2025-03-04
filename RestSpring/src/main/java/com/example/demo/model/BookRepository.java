package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<Book,Integer> {

	public List<Book> findByBookname(String name);
	public List<Book> findByPrice(int price);
	public List<Book> findByOrderByPriceAsc();
	// select * from book order by price asc;
	public List<Book> findByBookidOrBookname(int id,String name);
	// select * from book where bookid=id or booknaname=name
	public Book findByBookidAndBookname(int id,String name);
	
	@Query
	("select max(b.price) from Book b")
	public double maxPrice();
}
