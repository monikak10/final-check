package com.cognizant.moviecruiser.model;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
	private List<Movie> movieList;
	private long noOfFavorite;
	private long totalGross;

	public Favorite() {
		super();
		movieList = new ArrayList<>();
	}

	public Favorite(List<Movie> movieList, long noOfFavorite, long totalGross) {
		super();
		this.movieList = movieList;
		this.noOfFavorite = noOfFavorite;
		this.totalGross = totalGross;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public long getNoOfFavorite() {
		return noOfFavorite;
	}

	public void setNoOfFavorite(long noOfFavorite) {
		this.noOfFavorite = noOfFavorite;
	}

	public long getTotalGross() {
		return totalGross;
	}

	public void setTotalGross(long totalGross) {
		this.totalGross = totalGross;
	}

}
