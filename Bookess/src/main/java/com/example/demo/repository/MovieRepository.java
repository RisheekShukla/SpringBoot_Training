package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

//	Object addMovie(Movie movie);

//	Movie findMovieById(String moviecode);

	List<Movie> findByMovietitle(String name);

	List<Movie> findByMoviecodeAndMovietitle(int mid, String mname);

	List<Movie> findMovieByMoviecode(int moviecode);
	
	@Query("SELECT m FROM Movie m WHERE m.price = (SELECT MAX(m2.price) FROM Movie m2)")
    Movie findMaxPriceMovie();
	
    List<Movie> findAllByOrderByPriceAsc();
}
