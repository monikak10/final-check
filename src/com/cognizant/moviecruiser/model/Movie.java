package com.cognizant.moviecruiser.model;

import java.text.NumberFormat;
import java.util.Date;

import com.cognizant.moviecruiser.util.DateUtil;

public class Movie {
	private long id;
	private String title;
	private long boxOffice;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTreaser;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(long id, String title, long boxOffice, boolean active, Date dateOfLaunch, String genre,
			boolean hasTreaser) {
		super();
		this.id = id;
		this.title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTreaser = hasTreaser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTreaser() {
		return hasTreaser;
	}

	public void setHasTreaser(boolean hasTreaser) {
		this.hasTreaser = hasTreaser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public String custString() {
		String  print= String.format("%-25s $ %-20s  %-15s %-5s  Add to Favorite", title, boxOffice,
				 genre, hasTreaser ? "Yes" : "NO");
		return print;
	}
		
	
	public String toString() {
		NumberFormat box = NumberFormat.getInstance();
		box.setGroupingUsed(true);
		box.format(boxOffice);
		String details = String.format("%-25s $ %-20s  %-5s %-15s %-20s %-5s Edit", title, boxOffice,
				active ? "Yes" : "NO", DateUtil.covertToString(dateOfLaunch), genre, hasTreaser ? "Yes" : "NO");
		return details;
	}

}
