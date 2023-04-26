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
	
	</div>
<div align="center" style="color: silver;">These are technology were added by ${userID} </div>

	<table class="table table-dark table-hover">
		<tr>
			<th>Technology Name</th>
			<th>Technology Language</th>
			<th>Technology version</th>
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
				<td>${r.teSupportTo}</td>
				<td>${r.teLicense}</td>
				<td>${r.teOpenSource}</td>
				<td>${r.teOsType}</td>
			</tr>
		</c:forEach>

	</table>
	
	<div>
	<table>
	<tr>
	<td> <form action="techName" >  Search By Technology Name <input type="search"  name="teName">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search"> </form>
	</td>
	<td> <form action="techLanguage" >  Search By Technology Language <input type="search"  name="teLangauge">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search"> </form>
	</td>
	<td> <form action="techVersion" >  Search By Technology version <input type="search"  name="teVersion">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search"> </form>
	</td>
	</tr>
	<tr>
	<td>
	<form action="techSupportFrom"> Search By Technology Support From <input type="search" name="teSupportFrom">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search">
	</form>
	</td>
	<td>
	<form action="techSupportTo"> Search By Technology Support to <input type="search" name="teSupportTo">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search">
	</form>
	</td>
	<td>
	<form action="techOwner"> Search By Technology Owner <input type="search" name="teOwner">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search">
	</form>
	</td>
	</tr>
	<tr>
	<td>
	<form action="techLicense"> Search By Technology License <input type="search" name="teLicense">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search">
	</form>
	</td>
	<td>
	<form action="techOpenSource"> Search By Technology Source <input type="search" name="teOpenSource">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search">
	</form>
	</td>
	<td>
	<form action="techOsType"> Search By Technology OS Type <input type="search" name="teOsType">
	<input type="hidden" value="${userID}" name="userId">
	<input type="submit" value="Search">
	</form>
	</td>
	</tr>
	</table>
     </div>
</body>
</html>