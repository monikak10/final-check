package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoSqlImplTest {
	public static void main(String args[]) throws ParseException {
		System.out.println("Admin movie list :");
		testMovieListAdmin();
		System.out.println("customer movie list :");
		testMovieListCustomer();
		testModifyMovie();
		System.out.println("After  Modifying the movie :");
		testMovieListAdmin();

	}

	public static void testMovieListAdmin() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();
		for (Movie x : movieList) {
			System.out.println(x);
		}
	}

	public static void testMovieListCustomer() throws ParseException {
		MovieDao movieDao = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();
		for (Movie x : movieList) {
			System.out.println(x);
		}
	}

	public static void testModifyMovie() throws ParseException {
		Movie item = new Movie(2l, "HeartString", 54854545, true, DateUtil.convertToDate("20/08/2018"), "Science Fiction",
				true);
		MovieDao movieDao = new MovieDaoSqlImpl();
		movieDao.modifyMovie(item);
		Movie modifiedMovie = movieDao.getMovie(item.getId());

	}

}
