package com.adithya.javabrains.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adithya.javabrains.moviecatalogservice.models.CatalogItem;
import com.adithya.javabrains.moviecatalogservice.models.Movie;
import com.adithya.javabrains.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/" + userId, UserRating.class);
		
		return ratings.getUserRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "cars", rating.getRating());
                })
                .collect(Collectors.toList());
	}

}
