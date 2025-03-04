package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.ProductRepository;


@RestController
public class ProductController {
	@Autowired
	ProductRepository prep;
	
	
	@GetMapping("/retreive")
	public List<Product> retreive()
	{
		return prep.findAll();
	}
	@PostMapping("/insert")
	public Product insertData(@RequestBody Product p)
	{
		return prep.save(p);
	}
	
	@GetMapping("/retreiveData/{pid}")
	public Product getProduct(@PathVariable("pid")int id)
	{
		Optional<Product>pdata = prep.findById(id);
		if(pdata.isEmpty())
		{
			return null;
		}
		else
		{
			return pdata.get();
		}
	}
	
	@GetMapping("/retreiveNameData/{pname}")
	public List<Product> getProdbyName(@PathVariable("pname")String name)
	{
		return prep.findByProductname(name);
	}
	
	@GetMapping("/retreivePriceData/{bprice}")
	public List<Product> getProdbyPrice(@PathVariable("pprice")int price)
	{
		return prep.findByPrice(price);
	}

	@GetMapping("/retreiveAsc")
	public List<Product> retreiveAscData()
	{
		return prep.findByOrderByPriceAsc();
	}
	@PutMapping("/updateData/{pid}")
	public Product updateData(@PathVariable("pid")int id,@RequestBody Product p)
	{
		Product updateProd = null;
		Optional<Product> proddata = prep.findById(id);
		if(proddata.isPresent())
		{
			updateProd = proddata.get();
			updateProd.setProductid(p.getProductid());
			updateProd.setProductname(p.getProductname());
			updateProd.setPrice(p.getPrice());
			updateProd.setQuantity(p.getQuantity());
			updateProd.setDescr(p.getDescr());
			prep.save(p);
		}
		return updateProd;
	}

	@DeleteMapping("/deleteData/{pid}")
	public void deleteData(@PathVariable("pid")int id)
	{
		prep.deleteById(id);
	}
	
	@DeleteMapping("/deleteDatabyPrice/{price}")
	public void deleteDatabyPrice(@PathVariable("price")int prc)
	{
		prep.deleteByPrice(prc);
	}
}
