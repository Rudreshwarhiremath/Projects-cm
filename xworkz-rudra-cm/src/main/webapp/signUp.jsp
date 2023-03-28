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
				alt="" width="80" height="48" class="d-inline-block align text-top">
				<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">
		</div>
	</nav>
	<h1 style="color: green;">${message}</h1>
	<h5 style="color: red;">${messag}<br>
	<c:forEach items="${errors}" var="e">${e.message}</c:forEach>
	</h5>
	<form action="save" method="post"> 
User ID	<input type="text" name="userId"> <br>
Email<input type="email" name="email"> <br>
Mobile Number<input type="number" name="mobile"> <br>
Password<input type="password" name="password"> <br>
Confirm Password<input type="password" name="confirmPassword"> <br>
Agreement <input type="checkbox" name="agreement" id="agreementConform" onclick="onconform()"> <br>
<button type="submit" class="btn btn-success" id="submitId"  disabled="true">SignUp</button>
</form>

<script>
function onconform() {
var agree=document.getElementById('agreementConform');
console.log(agree.checked);
if(agree.checked){
	document.getElementById('submitId').disabled=false;
}else{
	document.getElementById('submitId').disabled='disabled';
}
	
}



</script>
</body>
</html>