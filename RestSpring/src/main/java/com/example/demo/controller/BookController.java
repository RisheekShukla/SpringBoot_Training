package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.BookRepository;

@RestController
// combination of Controller and ResponseEntity annotations
public class BookController {
	@Autowired
	BookRepository bookrep;
	// GetMapping - to retrieve data
	// PostMapping - to insert data
	// PutMapping - to update data
	// DeleteMapping - to delete data
	
	@GetMapping("/retreive")
	public List<Book> retreive()
	{
		return bookrep.findAll();
	}
	@PostMapping("/insert")
	public Book insertData(@RequestBody Book b)
	{
		return bookrep.save(b);
	}
	@GetMapping("/retreiveData/{bid}")
	public ResponseEntity<Object> getBook(@PathVariable("bid")int id)
	{
		Optional<Book>bookdata = bookrep.findById(id);
		if(bookdata.isEmpty())
		{
			return new ResponseEntity<>("Data not found",HttpStatus.NOT_FOUND);
		}
		else
		{
			Book b = bookdata.get();
			return new ResponseEntity<>(b,HttpStatus.OK);
		}
	}
	@GetMapping("/retreiveNameData/{bname}")
	public List<Book>  getBookbyName(@PathVariable("bname")String name)
	{
		if(bookrep.findByBookname(name).isEmpty())
		{
			System.out.println();
			throw new BookNotFoundException();
		}
		return bookrep.findByBookname(name);
//		 return new ResponseEntity<>(b,HttpStatus.OK);
	}
	@GetMapping("/retreivePriceData/{bprice}")
	public List<Book> getBookbyPrice(@PathVariable("bprice")int price)
	{
		return bookrep.findByPrice(price);
	}
	
	@GetMapping("/retreiveAsc")
	public List<Book> retreiveAscData()
	{
		return bookrep.findByOrderByPriceAsc();
	}
	@PutMapping("/updateData/{bid}")
	public Book updateData(@PathVariable("bid")int id,@RequestBody Book b)
	{
		Book updateBook = null;
		Optional<Book> bookdata = bookrep.findById(id);
		if(bookdata.isPresent())
		{
			updateBook = bookdata.get();
			updateBook.setBookid(b.getBookid());
			updateBook.setBookname(b.getBookname());
			updateBook.setPrice(b.getPrice());
			updateBook.setQuantity(b.getQuantity());
			bookrep.save(updateBook);
		}
		return updateBook;
	}
	
	@DeleteMapping("/deleteData/{bookid}")
	public void deleteData(@PathVariable("bookid")int id)
	{
		bookrep.deleteById(id);
	}
	
	@GetMapping("/retreivebyidandname/[bookid]/[bookname]")
	public Book retreivetheData(@PathVariable("bookname")String name,@PathVariable("bookid") int id)
	{
		return bookrep.findByBookidAndBookname(id, name);
	}
	@GetMapping("/MaxPrice")
	public double maxvalue()
	{
		return bookrep.maxPrice();
	}
}
