<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Favorite Notification</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
<script type="text/javascript" src="./js/script.js"></script>
</head>
<body>
	<header>
		<span class="span-edit">Movie Cruiser</span> <img class="img-edit"
			src="./images/logo.png" /> <a id="menu" href="ShowFavorite">Favorites</a>
		<a id="menu" href="ShowMovieListCustomer">Movies</a>
	</header>
	<div>
		<h1 class="h1-edit">Favorites</h1>
		<h3 class="head-color">${msg}</h3>
		<table class="table-edit">
			<tr>
				<th class="txt-left">Title</th>
				<th class="txt-right">Box Office</th>
				<th class="txt-center">Genre</th>
				<th class="txt-center">Has Teaser</th>
			</tr>
			<c:forEach items="${movieList}" var="movie">
				<tr>
					<td class="txt-left">${movie.title}</td>
					<td class="txt-right">$${movie.boxOffice}</td>
					<td class="txt-center">${movie.genre}</td>
					<td class="txt-center"><c:if test="${movie.hasTreaser}">Yes</c:if>
						<c:if test="${!movie.hasTreaser}">No</c:if></td>
					<td class="txt-center"><a
						href="RemoveFavorite?movieId=${movie.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>
		<h4 class="txt">No. of Favorites: ${total}</h4>
	</div>
	<footer>
		<span id="col"> copyright @ 2019 </span>
	</footer>
</body>
</html>
