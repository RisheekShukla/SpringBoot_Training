package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	MovieRepository mrep;

	@PostMapping("/add")
	public Movie addMovie(@RequestBody Movie movie) 
	{
		return mrep.save(movie);
	}

	@GetMapping("getmovie/{moviecode}")
	public List<Movie> getMovieById(@PathVariable int moviecode) 
	{
		if (mrep.findMovieByMoviecode(moviecode).isEmpty()) {
			System.out.println();
			throw new MovieNotFoundException();
		} else {
			return mrep.findMovieByMoviecode(moviecode);
		}
	}
	@GetMapping("/getmovie/name/{mname}")
	public List<Movie> getMovieByName(@PathVariable("mname") String name) 
	{
		return mrep.findByMovietitle(name);
	}

	@GetMapping("/getMovieByIdandName/{id}/{mname}")
	public List<Movie> getMovieByName(@PathVariable("id") int mid, @PathVariable("mname") String mname) 
	{
		return mrep.findByMoviecodeAndMovietitle(mid, mname);
	}

	
	@GetMapping("/maxprice")
	@PreAuthorize("hasRole('ADMIN')")
	public Movie getMostExpensiveMovie() 
	{
		return mrep.findMaxPriceMovie();
	}
	@GetMapping("/orderit")
	public List<Movie> getSortedByPrice() 
	{
        return mrep.findAllByOrderByPriceAsc();
    }
}
