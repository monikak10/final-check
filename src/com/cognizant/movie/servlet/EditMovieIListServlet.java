package com.cognizant.movie.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

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
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieIListServlet
 */
@WebServlet("/EditMovieItem")
public class EditMovieIListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieIListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("movieId"));
		String title = request.getParameter("txtName");
		long boxOffice = Long.parseLong(request.getParameter("txtGross"));
		boolean active = request.getParameter("radioButton").equalsIgnoreCase("Yes");
		String dateOfLaunch = request.getParameter("dol");
		String genre = request.getParameter("genre");
		boolean hasTreaser = request.getParameter("checkBox") != null;
		try {
			Movie m = new Movie(id, title, boxOffice, active, DateUtil.convertToDate(dateOfLaunch), genre, hasTreaser);
			MovieDao movieDao = new MovieDaoSqlImpl();
			movieDao.modifyMovie(m);
			request.setAttribute("msg", "Movie List modified successfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
