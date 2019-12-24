package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorite> userFavorite;

	public FavoriteDaoCollectionImpl() {
		super();
		if (userFavorite == null) {
			userFavorite = new HashMap<>();
			userFavorite.put(1l, new Favorite());
		}
	}

	@Override
	public void addFavorite(long userId, long movieId) {
		try {
			MovieDao movieDao = new MovieDaoCollectionImpl();
			Movie movies = movieDao.getMovie(movieId);
			if (userFavorite.containsKey(userId)) {
				userFavorite.get(userId).getMovieList().add(movies);
			} else {
				Favorite fav = new Favorite();
				ArrayList<Movie> movieList = new ArrayList<>();
				movieList.add(movies);
				fav.setMovieList(movieList);
				userFavorite.put(userId, fav);

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		List<Movie> movieList = userFavorite.get(userId).getMovieList();
		Favorite fav = userFavorite.get(userId);
		long noOfFav = 0;
		if (fav == null || movieList.isEmpty()||fav.getMovieList()==null) {
				throw new FavoriteEmptyException();
			
		} else {
			for (Movie x : movieList) {
				noOfFav = noOfFav + x.getBoxOffice();
			}
		}
		fav.setNoOfFavorite(noOfFav);
		return movieList;
	}

	@Override
	public void removeFavorite(long userId, long movieId) {
		List<Movie> movieList = userFavorite.get(userId).getMovieList();
		for (Movie s : movieList) {
			if (s.getId() == movieId) {
				movieList.remove(s);
			}
			break;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		}

	}

}
