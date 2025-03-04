package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Product;
import com.example.demo.model.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	ProductRepository prep;
	@RequestMapping("/pform")
	public ModelAndView showForm()
	{
		return new ModelAndView("handler","proddata",new Product());
	}
	
	@RequestMapping(path="/insertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("proddata") Product p)
	{
		prep.save(p);
		System.out.println("pcode is "+p.getProductcode());
		System.out.println("pname is "+p.getProductname());
		System.out.println("price is "+p.getPrice());
		System.out.println("quantity is "+p.getQuantity());
		return "success";
	}
}

