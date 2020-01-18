package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoriteDao;
import com.cognizant.moviecruiser.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoriteDaoSqlImpl;

/**
 * Servlet implementation class AddToFevoriteServlet
 */
@WebServlet("/AddToFevorite")
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoriteDao favoriteDao = new FavoriteDaoSqlImpl();
		long id = Long.parseLong(request.getParameter("movieId"));
		favoriteDao.addFavorite(1, id);
		request.setAttribute("msg", "Movie Added to Favorite Successfully.");
		RequestDispatcher rd = request.getRequestDispatcher("ShowMovieListCustomer");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
