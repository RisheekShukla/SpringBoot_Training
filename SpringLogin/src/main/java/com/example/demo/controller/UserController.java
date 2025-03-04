package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.User;

@Controller
public class UserController {
	
	@RequestMapping("/login")
	public ModelAndView loginDisplay()
	{
		System.out.println("check");
		return new ModelAndView("handler","logindata",new User());
	}
	
	@RequestMapping(path="/insertData",method=RequestMethod.POST)
	public String insertData(@ModelAttribute("logindata") User u)
	{
		System.out.println("Username is "+u.getUsername());
		System.out.println("Password is "+u.getPassword());
		if(u.getUsername().equals("admin") && u.getPassword().equals("admin"))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}
