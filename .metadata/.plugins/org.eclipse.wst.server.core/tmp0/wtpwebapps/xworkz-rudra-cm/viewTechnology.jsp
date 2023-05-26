<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-Workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top"></a>
				<div>
				<a href="LoginSucess.jsp" class="btn btn-info">Home</a>
			<span	style="color: white;">Welcome ${userID}</span> <img
				src="download?fileName=${dtoPic}" height="50" width="80">
				</div>
		</div>
	</nav>
	<div>
	<div style="color: purple;" align="center" > <h2> Search Bar </h2></div>
	<form action="searchTechnology" > 
	
	<div align="center"> <input type="search"  name="teName" placeholder="Technology Name">
	 <input type="search" name="teLangauge" placeholder="Technology Language">
	 <input type="search" name="teVersion" placeholder="Technology Version">
	 <input type="search" name="teOwner" placeholder="Technology Owner">
	 <input type="search" name="teSupportFrom" placeholder="Support From">
	 <input type="search" name="teSupportTo" placeholder="Support to">
	 <input type="search" name="teLicense" placeholder="License"></div>
	 <div align="center"><input type="search" name="teOpenSource" placeholder="Open source">
	 <input type="search" name="teOsType" placeholder="OS Type"></div>
	 <input type="hidden" value="${userID}" name="userId">
	<div align="center">  <input type="submit" value="Search" class="btn btn-secondary"></div> </form>
	</div>
<div align="center" style="color:darkgreen;">These are technology were added by ${userID} </div>

	<table class="table table-dark table-hover">
		<tr>
			<th>Technology Name</th>
			<th>Technology Language</th>
			<th>Technology Version</th>
			<th>Technology Owner</th>
			<th>Support From</th>
			<th>Support to</th>
			<th>License</th>
			<th>Open source</th>
			<th>OS Type</th>
		</tr>
		<c:forEach items="${list}" var="r">
			<tr>
				<td>${r.teName}</td>
				<td>${r.teLangauge}</td>
				<td>${r.teVersion}</td>
				<td>${r.teOwner}</td>
				<td>${r.teSupportFrom}</td>
				<td>${r.teSupportFrom}</td>
				<td>${r.teLicense}</td>
				<td>${r.teOpenSource}</td>
				<td>${r.teOsType}</td>
			</tr>
		</c:forEach>

	</table>
	<div align="center"><a href="view?userId=${userID}" class="btn btn-info">View Technologies</a></div>
</body>
</html>