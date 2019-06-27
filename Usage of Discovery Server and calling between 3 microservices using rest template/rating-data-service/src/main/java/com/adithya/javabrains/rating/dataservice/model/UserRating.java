package com.adithya.javabrains.rating.dataservice.model;

import java.util.List;

public class UserRating {
	
	public UserRating() {
		// TODO Auto-generated constructor stub
	}
	
	private List<Rating> userRatings;

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}
	
	

}
