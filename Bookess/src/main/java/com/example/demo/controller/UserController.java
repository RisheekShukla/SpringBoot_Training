package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userep;
	
	@PostMapping("/insert")
	public ResponseEntity<User> insertData(@RequestBody User u)
	{
		userep.save(u);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	 @GetMapping("getuser/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) 
	 {
		 return ResponseEntity.ok(userep.findById(id));
	 }
	
	 @DeleteMapping("delete/{usercode}")
	 public ResponseEntity<String> deleteUser(@PathVariable int usercode) {
	        userep.deleteById(usercode);
	        return ResponseEntity.ok("User deleted successfully");
	    }
	 
//	 @PostMapping("/{userId}/addmovie")
//	 public ResponseEntity<Object> addMovieToUser(@PathVariable int userId, @RequestBody Movie movie) 
//	 {
//	     return ResponseEntity.ok(userep.addMovieToUser(userId, movie));
//	 }

}
