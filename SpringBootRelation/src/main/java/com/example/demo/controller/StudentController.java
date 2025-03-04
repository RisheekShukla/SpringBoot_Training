package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository sturep;
	
	@PostMapping("/insert")
	public Student insertData(@RequestBody Student s)
	{
		return sturep.save(s);
	}
	
	@GetMapping("/addressDetails/{studentid}")
	public Address getAddress(@PathVariable("studentid")int id)
	{
		Optional<Student>stuobj = sturep.findById(id);
		Student s = null;
		if(stuobj.isEmpty())
		{
			s=stuobj.get();
		}
		Address ad=s.getAddobj();
		return ad;
	}
	
	
}
