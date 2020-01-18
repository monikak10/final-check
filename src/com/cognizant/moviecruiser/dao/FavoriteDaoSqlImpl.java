package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorite;
import com.cognizant.moviecruiser.model.Movie;

public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavorite(long userId, long movieId) {
		  Connection con = ConnectionHandler.getConnection();

	        try {
	               String sql = "insert into favorite(fv_us_id,fv_pr_id) values (?,?)";
	               PreparedStatement ps = con.prepareStatement(sql);
	               ps.setLong(1, userId);
	               ps.setLong(2, movieId);
	              int count=ps.executeUpdate();
	        } catch (Exception e) {
	               e.printStackTrace();
	        } finally {
	               try {
	                     con.close();
	               } catch (Exception e) {
	                     e.printStackTrace();
	               }

	        }
	}

	@Override
	public List<Movie> getAllFavorite(long userId) throws FavoriteEmptyException {
		Connection con = ConnectionHandler.getConnection();
		 Favorite favorite=new Favorite();
	     String sql="SELECT  m_title ,m_box_office,m_active,m_date_of_launch,m_genre,m_has_treaser FROM movie  INNER JOIN favorite ON fv_pr_id=m_id WHERE fv_us_id=?";
	     try {
			
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setLong(1, userId);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Movie m=new Movie();
					m.setTitle(rs.getString(1));
					m.setBoxOffice(rs.getLong(2));
					m.setActive(rs.getString(3).equalsIgnoreCase("Yes"));
					m.setDateOfLaunch(rs.getDate(4));
					m.setGenre(rs.getString(5));
					m.setHasTreaser(rs.getString(6).equalsIgnoreCase("Yes"));
					favorite.getMovieList().add(m);	
					}
				
		 }catch (Exception e) {
            e.printStackTrace();
     } finally {
            try {
                  con.close();
            } catch (Exception e) {
                  e.printStackTrace();
            }
     }
		return favorite.getMovieList();
	}

	@Override
	public void removeFavorite(long userId, long movieId) throws FavoriteEmptyException {
		 Connection con = ConnectionHandler.getConnection();
	        try {
	        	 String sql = "delete from favorite where fv_us_id=? and fv_pr_id=?";
	             PreparedStatement ps = con.prepareStatement(sql);
	             ps.setLong(1, userId);
	             ps.setLong(2,movieId);
	             int count=ps.executeUpdate();
	        } catch (Exception e) {
	               e.printStackTrace();
	        } finally {
	               try {
	                     con.close();
	               } catch (SQLException e) {
	                     e.printStackTrace();
	               }

	        }
		
	}

}
