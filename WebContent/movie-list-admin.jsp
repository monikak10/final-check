<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>>
<html>
<head>
<title>Movie list Admin</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
</head>
<body>
	<header>
		<span class="span-edit">Movie Cruiser</span> <img class="img-edit"
			src="./images/logo.png" /> <a id="menu" href="ShowMovieListAdmin">Movies</a>
	</header>
	<div>
		<h1 class="h1-edit">Movies</h1>
		<h3 class="head-color1">${msg}</h3>
		<form>
			<table class="table-edit">
				<tr>
					<th class="txt-left">Title</th>
					<th class="txt-right">Box Office</th>
					<th class="txt-center">Active</th>
					<th class="txt-center">Date of Launch</th>
					<th class="txt-center">Genre</th>
					<th class="txt-center">Has Teaser</th>
					<th class="txt-center">Action</th>
				</tr>
				<c:forEach items="${movieList}" var="movie">
					<tr>
						<td class="txt-left">${movie.title}</td>
						<td class="txt-right">$${movie.boxOffice}</td>
						<td class="txt-center"><c:if test="${movie.active}">Yes</c:if>
							<c:if test="${!movie.active}">No</c:if></td>
						<td class="txt-center"><fmt:formatDate pattern="dd/MM/yyyy"
								value="${movie.dateOfLaunch}"></fmt:formatDate></td>
						<td class="txt-center">${movie.genre}</td>
						<td class="txt-center"><c:if test="${movie.hasTreaser}">Yes</c:if>
							<c:if test="${!movie.hasTreaser}">No</c:if></td>

						<td class="txt-center"><a
							href="ShowEditMovieList?movieId=${movie.id}">Edit</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>
	<footer>
		<span id="col"> copyright @ 2019 </span>
	</footer>
</body>
</html>

