package com.cognizant.moviecruiser.dao;

import java.lang.*;

public class FavoriteEmptyException extends Exception {

	public FavoriteEmptyException() {
		super("Favorite is Empty");

	}

	public FavoriteEmptyException(String message) {
		super(message);

	}

}
