<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Edit Movies</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
<script type="text/javascript" src="./js/script.js"></script>
</head>
<body>
	<header>
		<span class="span-edit">Movie Cruiser</span> <img class="img-edit"
			src="./images/logo.png" /> <a id="menu" href="ShowMovieListAdmin">Movies</a>
	</header>
	<div>
		<h1 class="h1-edit">Edit Movies</h1>

		<form name="myform" action="EditMovieItem?movieId=${movieList.id}"
			method="post" onsubmit="return validate()">
			<table class="table-edit">
				<tr>
					<th class="txt-left"><label for="txt1"> Title</label></th>
				</tr>
				<tr>
					<td colspan="4" class="txt-left"><input type="text"
						name="txtName" id="txt1" value="${movieList.title}" /></td>
				</tr>

				<tr>
					<th class="txt-left tr-margi"><label for="txt2">Gross($)</label>
					</th>
					<th class="txt-left"><label>Active</label></th>
					<th class="txt-center"><label for="txt3">Date of
							Launch</label></th>
					<th class="txt-left"><label>Genre</label></th>
				</tr>
				<tr>
					<td class="txt-left"><input type="text" name="txtGross"
						id="txt2" value="${movieList.boxOffice}" /></td>
					<td class="txt-left"><input type="radio" name="radioButton"
						id="rb1" value="yes"
						<c:if test="${movieList.active eq 'true'}"> checked="checked"</c:if> />
						<label for="rb1">Yes</label> <input type="radio"
						name="radioButton" id="rb2" value="no"
						<c:if test="${movieList.active eq 'false'}"> checked="checked" </c:if> />
						<label for="rb2">No</label></td>
					<td class="txt-center"><input type="text" name="dol" id="txt3"
						value="<fmt:formatDate type="date" pattern = 'dd/MM/yyyy' value='${movieList.dateOfLaunch}'></fmt:formatDate>" />
					</td>
					<td class="txt-left"><select name="genre">
							<option
								<c:if test="${movieList.genre eq 'Superhero'}">selected</c:if>>Superhero</option>
							<option
								<c:if test="${movieList.genre eq 'Science Fiction'}">selected</c:if>>Science
								Fiction</option>
							<option
								<c:if test="${movieList.genre eq 'Romance'}">selected</c:if>>Romance</option>
							<option
								<c:if test="${movieList.genre eq 'Comedy'}">selected</c:if>>Comedy</option>
							<option
								<c:if test="${movieList.genre eq 'Adventure'}">selected</c:if>>Adventure</option>
							<option
								<c:if test="${movieList.genre eq 'Thriller'}">selected</c:if>>Thriller</option>
					</select></td>
				</tr>
				<tr>
					<td class="txt-left"><input type="checkbox" id="cb"
						name="checkBox"
						<c:if test="${movieList.hasTreaser eq 'true'}">checked="checked"</c:if>
						<c:if test="${movieList.hasTreaser eq 'false'}">checked="checked"</c:if> />Has
						Teaser</td>
				</tr>

				<tr>
					<td class="txt-left"><input type="submit" value="Save" id="s1"
						name="sub" class="col-button" /></td>
				</tr>
			</table>
		</form>
	</div>
	<footer>
		<span id="col"> copyright @ 2019 </span>
	</footer>
</body>
</html>

