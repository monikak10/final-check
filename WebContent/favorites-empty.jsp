<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>Favorite Empty</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
<script type="text/javascript" src="./js/script.js"></script>
</head>
<body>
	<header>
		<span class="span-edit">Movie Cruiser</span> <img class="img-edit" src="./images/logo.png" /> <a id="menu" href="ShowFavorite">Favorites</a>
		<a id="menu" href="ShowMovieListCustomer">Movies</a>
	</header>
	<div>
		<h1 class="h1-edit1">Favorites</h1>
		<h3 class="h-color">
			No items in favorite.Use 'Add to Favorite' option in <a id="a2-color"
				href="ShowMovieListCustomer">'Movie list'</a>
		</h3>
	</div>
	<footer>
		<span id="col"> copyright @ 2019 </span>
	</footer>
</body>
</html>
