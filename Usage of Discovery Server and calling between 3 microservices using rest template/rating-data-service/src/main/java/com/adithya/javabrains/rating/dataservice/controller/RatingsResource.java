package com.adithya.javabrains.rating.dataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adithya.javabrains.rating.dataservice.model.Rating;
import com.adithya.javabrains.rating.dataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }
    @RequestMapping("users/{userId}")
    public UserRating getRating(@PathVariable("userId") String userId) {
        List<Rating> list = Arrays.asList(
				new Rating("1234", 4),
				new Rating("4567", 3)
				);
        UserRating rating = new UserRating();
        rating.setUserRatings(list);
        return rating;
        
    }
}