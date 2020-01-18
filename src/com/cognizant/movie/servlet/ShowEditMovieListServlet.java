package com.cognizant.movie.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movie;

/**
 * Servlet implementation class ShowEditMovieListServlet
 */
@WebServlet("/ShowEditMovieList")
public class ShowEditMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEditMovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDao movieDao;
		try {
			movieDao = new MovieDaoSqlImpl();
			long id=Long.parseLong(request.getParameter("movieId"));
			Movie  movieList = movieDao.getMovie(id);
			request.setAttribute("movieList", movieList);
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
