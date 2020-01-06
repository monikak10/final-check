<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Movie list Customer</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
</head>
<body>
	<header>
		<span class="span-edit">Movie Cruiser</span> <img class="img-edit"
			src="./images/logo.png" /> <a id="menu" href="ShowFavorite">Favorites</a>
		<a id="menu" href="ShowMovieListCustomer">Movies</a>
	</header>
	<div>
		<h1 class="h1-edit">Movies</h1>
		<h3 class="head-color">${msg}</h3>
		<form>
			<table class="table-edit3">
				<tr>
					<th class="txt-left">Title</th>
					<th class="txt-right">Box Office</th>
					<th class="txt-center">Genre</th>
					<th class="txt-center">Has Teaser</th>
					<th class="txt-center">Action</th>
				</tr>
				<c:forEach items="${movieList}" var="movie">
					<tr>
						<td class="txt-left">${movie.title}</td>
						<td class="txt-right">$${movie.boxOffice}</td>
						<td class="txt-center">${movie.genre}</td>
						<td class="txt-center"><c:if test="${movie.hasTreaser}">Yes</c:if>
							<c:if test="${!movie.hasTreaser}">No</c:if></td>
						</td>
						<td class="txt-center"><a
							href="AddToFevorite?movieId=${movie.id}">Add to Favorite</a></td>
					<tr>
				</c:forEach>

			</table>
		</form>
		<footer>
			<span id="col"> copyright @ 2019 </span>
		</footer>
</body>
</html>

