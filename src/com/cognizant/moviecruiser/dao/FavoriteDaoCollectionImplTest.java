package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImplTest {

	public static void main(String[] args) throws FavoriteEmptyException {
		testGetAllFavorite();
		testAddFavorite();
		testRemoveFavorite();
		testGetAllFavorite();

	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		
		favoriteDao.addFavorite(1, 2l);
		favoriteDao.addFavorite(1, 4l);
		favoriteDao.addFavorite(2, 5l);
		favoriteDao.addFavorite(2, 3l);

		List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
		System.out.println("User Added Favorite Movie:");
		for (Movie movies : movieListCustomer) {
			System.out.println(movies);
			
		}
		System.out.println("Favorite are :" + movieListCustomer.size());
		
	}

	public static void testRemoveFavorite() {
		FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
		try {
			favoriteDao.removeFavorite(1, 2l);
			List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
			System.out.println("User After Remove Favorite Movie:");
			for (Movie movies : movieListCustomer) {
				System.out.println(movies);
			}
			
		} catch (FavoriteEmptyException e) {
			e.getMessage();
		}
	}

	public static void testGetAllFavorite() throws FavoriteEmptyException {
		
		
		try {
			FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
			List<Movie> movieListCustomer = favoriteDao.getAllFavorite(1);
			System.out.println("All Favorite Movie:");
			for (Movie movies : movieListCustomer) {
			System.out.println(movies);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
