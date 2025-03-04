package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;

@RestController
public class AddressController {
	@Autowired
	AddressRepository addrep;
	@GetMapping("/studentinfo/{addressid}")
	public String studentinfo(@PathVariable("addressid")int id)
	{
		String studentname = null;
		Optional<Address>adobj=addrep.findById(id);
		studentname = adobj.get().getSobj().getStudentname();
		return studentname;
	}
}
