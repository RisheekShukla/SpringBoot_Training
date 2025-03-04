package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/employes")
public class EmployeeController {
	@Autowired
	EmployeeRepository emprep;
	@PostMapping("/insertdata")
	public Employee insert(@RequestBody Employee e)
	{
		return emprep.save(e);
	}
}
