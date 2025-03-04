package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository drep;
	
	@PostMapping("/insert")
	public Department insertData(@RequestBody Department d)
	{
		return drep.save(d);
	}
	
}
