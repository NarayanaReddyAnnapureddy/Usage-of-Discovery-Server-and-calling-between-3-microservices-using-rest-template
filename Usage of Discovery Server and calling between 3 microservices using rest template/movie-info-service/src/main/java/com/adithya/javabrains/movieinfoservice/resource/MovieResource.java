package com.adithya.javabrains.movieinfoservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adithya.javabrains.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Test Name");
	}

}
